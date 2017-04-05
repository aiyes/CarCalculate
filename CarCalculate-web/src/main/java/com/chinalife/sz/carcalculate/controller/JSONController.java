package com.chinalife.sz.carcalculate.controller;

import com.chinalife.sz.carcalculate.utils.WebConfigUtils;
import com.chinalife.sz.cc.domain.*;
import com.chinalife.sz.cc.model.combos.CombosSchemaDTO;
import com.chinalife.sz.cc.model.common.ServiceRequestID;
import com.chinalife.sz.cc.model.order.OrderInfoDTO;
import com.chinalife.sz.cc.service.WebUtils;
import com.prs.framework.core.exception.WebControllerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
/**
 * Created by tianwei on 2016/7/21.
 */
@Controller
public class JSONController {
	//	private static ThreadLocal<BlockingQueue<String>>  errorResult= new ThreadLocal<BlockingQueue<String>>();
	@Autowired
	private WebUtils webUtils;

	public static ConcurrentHashMap<String,byte[]> concurrentHashMap=new ConcurrentHashMap<String,byte[]>();

	//	下载pdf
	@RequestMapping(value = "/download/{demandNo}", method = RequestMethod.GET)
	public void downLoadFile(@PathVariable("demandNo")  String  demandNo,
							 HttpServletResponse response) {
		try {
			// get your file as InputStream
			ByteArrayInputStream is = new ByteArrayInputStream(concurrentHashMap.get(demandNo));
			// copy it to response's OutputStream
			response.setContentType("application/pdf");
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
			concurrentHashMap.remove(demandNo);
			response.flushBuffer();
		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}




	}
	//	生成pdf
	@RequestMapping(value = "/car/generatePDF/{demandNo}/{id}", method = RequestMethod.POST)
	public void generatePDF(@RequestBody PdfInfoRequest pdfInfo,  @PathVariable("demandNo")  String  demandNo,@PathVariable("id") String id,HttpServletResponse response){
//		ByteArrayInputStream bis ;
		Map<String,byte[]> map=new HashMap<String,byte[]>();

		map=webUtils.submit(pdfInfo,id,map);
		byte[] byteses = map.get(demandNo);
		map.clear();
		concurrentHashMap.put(demandNo,byteses);
	}

//	直接生成pdf
//@RequestMapping(value = "/car/generatePDF/{demandNo}/{id}", method = RequestMethod.POST)
//public void generatePDF(@RequestBody PdfInfoRequest pdfInfo,  @PathVariable("demandNo")  String  demandNo,@PathVariable("id") String id,HttpServletResponse response){
////		ByteArrayInputStream bis ;
//	Map<String,byte[]> map=new HashMap<String,byte[]>();
//
//	map=webUtils.submit(pdfInfo,id,map);
//	byte[] byteses = map.get(demandNo);
//	map.clear();
//	try {
//		ServletOutputStream outputStream = response.getOutputStream();
//		outputStream.write(byteses);
//		outputStream.flush();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//	concurrentHashMap.put(demandNo,byteses);
//}


	//信息查询  已废弃
	@RequestMapping(value = "/car/getCustomerInfo/{id}", method = RequestMethod.POST,produces = "application/json;charset:utf-8")
	@ResponseBody
	public PrpDcustomerIdvSchemaResponse getCustomerInfo(@RequestBody CustomerRequest customer, @PathVariable("id") String id,HttpServletResponse response) throws IOException {
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
//		logger.info("***********************************************************:" + customer.getCustomerCName());
		customer.setRequestType("5");
		customer.setComCode("44030000");
		PrpDcustomerIdvSchemaResponse customerResponse = new PrpDcustomerIdvSchemaResponse();
		customerResponse=webUtils.submit(customer, id, customerResponse);
		System.out.println(customerResponse);
		return customerResponse;
	}
	//保单查询
//	@ResponseBody
//	@RequestMapping(value="/car/getCarPolicyInfo/{id}",method = RequestMethod.POST)
//	public CarPolicyQueryResponse getCarPolicyInfo(@RequestBody CarPolicyRequest carPolicyRequest,@PathVariable("id") String id ){
//
//		carPolicyRequest.setRequestType("5");
//
//		CarPolicyQueryResponse  carPolicyResponse =  new CarPolicyQueryResponse();
//
//		carPolicyResponse=webUtils.submit(carPolicyRequest,id,carPolicyResponse);
//		System.out.println(carPolicyResponse);
//		return carPolicyResponse;
//	}
	//保单查询
	@ResponseBody
	@RequestMapping(value="/car/getCarPolicyInfo/{id}",method = RequestMethod.POST)
	public CarPolicyResponse getCarPolicyInfo(@RequestBody CarPolicyRequest carPolicyRequest,@PathVariable("id") String id ){

		carPolicyRequest.setRequestType("5");

		CarPolicyResponse  carPolicyResponse =  new CarPolicyResponse();

		carPolicyResponse=webUtils.submit(carPolicyRequest,id,carPolicyResponse);
		System.out.println(carPolicyResponse);
		return carPolicyResponse;
	}
	//保费计算
	@RequestMapping(value="/car/premiumCalculate/{id}",method = RequestMethod.POST)
	public @ResponseBody PremiumCalculateResponse premiumCalculate(@RequestBody PremiumCalculateRequest mainInfo, @PathVariable("id") String id,HttpServletResponse resp)  {
		int i = new Double(Double.parseDouble(mainInfo.getCarInfo().getCompleteKerbMass())).intValue();
		mainInfo.getCarInfo().setCompleteKerbMass(Integer.toString(i));
		System.out.println(mainInfo);
		PremiumCalculateResponse premiumCalculate= new PremiumCalculateResponse();
//		CombosDataResponse combosDataResponse = new CombosDataResponse();

		premiumCalculate=webUtils.submit(mainInfo,id,premiumCalculate);
		if(premiumCalculate==null){
			resp.setStatus(406);
		}
		else{
			if(premiumCalculate.getErrorMessage()!=null){
				resp.setStatus(405);
			}
		}
		return premiumCalculate;
	}
	//车型查询
	@RequestMapping(value="/car/getVehicleModelList/{id}",method = RequestMethod.POST)
	public @ResponseBody VehicleModelResponse getVehicleModelList(@RequestBody VehicleModelRequest vehicelModel,@PathVariable("id") String id,HttpServletResponse response){
//		System.out.println(vehicelModel);
		VehicleModelResponse vehicleModelResponse = new VehicleModelResponse();
		vehicleModelResponse = webUtils.submit(vehicelModel, id, vehicleModelResponse);
		System.out.println(vehicleModelResponse);
		if(vehicleModelResponse==null){
			response.setStatus(406);
		}
		return vehicleModelResponse;
	}
	//历史数据复用
	@RequestMapping(value="/car/policyReuse/{id}",method = RequestMethod.POST)
	public @ResponseBody PolicyDataReuseResponse policyReuse(@RequestBody PolicyDataReuseRequest policy,@PathVariable("id") String id,HttpServletResponse resp){
		System.out.println(policy);
		PolicyDataReuseResponse  response = new PolicyDataReuseResponse();
		response=webUtils.submit(policy,id,response);
		if(response==null){
			resp.setStatus(406);
		}
		else {
			if("1".equals(policy.getRelationFlag())){
				response.getMainEhm().setBzStartDate(WebConfigUtils.addOneYear(policy.getBzStartDate()));
				response.getMainEhm().setBzEndDate(WebConfigUtils.addOneYear(policy.getBzEndDate()));
			}

		}
		return response;
	}
	//	销售信息
	@RequestMapping(value = "/car/getMarketInfo/{id}",method = RequestMethod.POST)
	public @ResponseBody MainResponse getMarketInfo(@RequestBody MainInfoRequest mainInfo,@PathVariable("id") String id){
		System.out.println(mainInfo);
		MainResponse response = new MainResponse();
		response=webUtils.submit(mainInfo,id,response);
		System.out.println(response);
		return  response;
	}

//	手续费计算
	@RequestMapping(value = "/car/poundageCalculate/{id}",method=RequestMethod.POST)
	public @ResponseBody Map poundageCalculate(@RequestBody String sSProposalNo,@PathVariable("id") String id){
		  Map response= new HashMap();
		System.out.println(sSProposalNo);
		response = webUtils.submit(sSProposalNo, id, response);
		return response;
	}

//	投保确认 转订单
	@RequestMapping(value = "/car/toOrder/{id}",method = RequestMethod.POST)
	public @ResponseBody Map  toOrder(@RequestBody OrderRequest order, @PathVariable("id") String id){
//		System.out.println(order.getApplicant().getAppliName());
		Map response= new HashMap();
		response=webUtils.submit(order,id,response);
		return response;
	}

//	订单查询
	@RequestMapping(value = "/order/findOrders/{id}",method = RequestMethod.POST)
	public @ResponseBody List<OrderInfoDTO> findOrders(@RequestBody OrderFormRequest orderForm,@PathVariable("id") String id){
		List<OrderInfoDTO> orderInfoDTOList= new ArrayList<OrderInfoDTO>();
//		System.out.println(orderForm.getInputStartDate());
		orderInfoDTOList=webUtils.submit(orderForm,id,orderInfoDTOList);

		return orderInfoDTOList;
	}

//	商业险套餐查询 修改 添加
	@RequestMapping(value = "/combos/saveCombos",method = RequestMethod.POST)
	public @ResponseBody
	CombosSchemaDTO saveComBos(@RequestBody CombosForm combosForm){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("combosForm",combosForm);
		try {
			model = com.prs.framework.core.web.controller.util.WebUtils.getResponseModel(model, ServiceRequestID.SAVE_COMBOS);

		} catch (WebControllerException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="/combos/getCombos",method=RequestMethod.POST)
	public @ResponseBody List<CombosSchemaDTO> getCombos(@RequestBody String userCode){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userCode",userCode);
		List<CombosSchemaDTO> combosSchemas=new ArrayList<CombosSchemaDTO>();
		try {
			model = com.prs.framework.core.web.controller.util.WebUtils.getResponseModel(model, ServiceRequestID.FIND_COMBOS);

			combosSchemas= (List)model.get("combosSchemas");
		} catch (WebControllerException e) {
			e.printStackTrace();
		}
		return combosSchemas;
	}

	@RequestMapping(value = "/combos/updateCombos",method = RequestMethod.POST)
	public @ResponseBody
	CombosSchemaDTO updateComBos(@RequestBody CombosSchemaDTO combosSchemaDTO){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("combosSchemaDTO",combosSchemaDTO);
		try {
			model = com.prs.framework.core.web.controller.util.WebUtils.getResponseModel(model, ServiceRequestID.UPDATE_COMBOS);

		} catch (WebControllerException e) {
			e.printStackTrace();
		}
		return null;
	}
@RequestMapping(value="/combos/deleteCombos/{userCode}/{id}",method = RequestMethod.DELETE)
public @ResponseBody CombosSchemaDTO deleteCombos(@PathVariable("userCode") String userCode, @PathVariable("id") Long id){
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("id",id);
	model.put("handlerCode",userCode);
	try {
		model = com.prs.framework.core.web.controller.util.WebUtils.getResponseModel(model, ServiceRequestID.DELETE_COMBOS);

	} catch (WebControllerException e) {
		e.printStackTrace();
	}
	return null;
}
	@RequestMapping(value = "/car/1",method = RequestMethod.POST)
	public @ResponseBody String getMarketInfo(@RequestBody String mainInfo,@PathVariable("id") String id){
//		System.out.println(mainInfo);
//		MainResponse response = new MainResponse();
//		response=webUtils.submit(mainInfo,id,response);
//		System.out.println(response);
//		return  response;
		return "hello";
	}
/*	public static ThreadLocal<BlockingQueue<String>> getErrorResult() {
		return null;
	}*/
}