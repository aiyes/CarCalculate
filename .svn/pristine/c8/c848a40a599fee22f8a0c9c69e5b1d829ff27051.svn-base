package com.chinalife.sz.carcalculate.service.impl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Service;

import com.chinalife.sz.carcalculate.utils.LogUtils;
import com.chinalife.sz.carcalculate.webservice.HandlerQueryServiceStub;
import com.chinalife.sz.carcalculate.webservice.HandlerQueryServiceStub.GetHandlerQuery;
import com.chinalife.sz.carcalculate.webservice.HandlerQueryServiceStub.HandlerQueryEhmRequest;
import com.chinalife.sz.carcalculate.webservice.HandlerQueryServiceStub.HandlerQueryEhmResponse;
import com.chinalife.sz.carcalculate.webservice.HandlerQueryServiceStub.IInsuranceExtensionEhm;
import com.chinalife.sz.carcalculate.webservice.HandlerQueryServiceStub.TXInsuranceRequestEhm;
import com.chinalife.sz.carcalculate.webservice.HandlerQueryServiceStub.TXInsuranceRequestExtensionEhm;
import com.chinalife.sz.carcalculate.webservice.HandlerQueryServiceStub.TransResultEhm;
import com.chinalife.sz.cc.log.service.LogService;
import com.chinalife.sz.cc.model.common.Constants;
import com.chinalife.sz.cc.model.log.LogDTO;
import com.prs.framework.core.exception.BusinessException;


public class HandlerQueryService {
	@Resource
	private LogService logService;
	
	public Map<String, Object> check(String handlerCode,String comCode,String handler1Code,String businessNature){
		final LogDTO logDTO = new LogDTO();
		Map<String, Object> model = new HashMap<String, Object>();
		logDTO.setServiceNme("寿险销售人员查询");
		logDTO.setCrtUsr(handler1Code);
		SimpleDateFormat df = new SimpleDateFormat();
		
		
		TXInsuranceRequestExtensionEhm extensionEhm=new TXInsuranceRequestExtensionEhm();
			extensionEhm.setOperator("SZ0_user");
			extensionEhm.setOperatorKey("SZ0_Pwd@gpic");
		//报文头部请求信息
		TXInsuranceRequestEhm requestEhm=new TXInsuranceRequestEhm();
		requestEhm.setTransType("request");
		requestEhm.setTransExeDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		requestEhm.setTransExeTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
		IInsuranceExtensionEhm insEhm=new IInsuranceExtensionEhm();
		insEhm.setPageFlag("0");
		requestEhm.setIInsuranceExtensionEhm(insEhm);
		
		HandlerQueryEhmRequest request = new HandlerQueryEhmRequest();
		request.setTXInsuranceRequestEhm(requestEhm);
		request.setTXInsuranceRequestExtensionEhm(extensionEhm);
		request.setRequestType("SZ0");
		request.setComCode(comCode);//精确至省分公司一级，不匹配时会返回提示：该寿险营销员不归属该省分公司!
		request.setHandler1Code(handler1Code);
		request.setHandlerCode(handlerCode);
		request.setBusinessNature(businessNature);
		
		GetHandlerQuery query = new GetHandlerQuery();
		query.setRequest(request);
		HandlerQueryEhmResponse response;
		try {
			logDTO.setReqTm(df.format(new Date()));
			logDTO.setReqXml(LogUtils.writeObject2String(request));
			response = new HandlerQueryServiceStub().getHandlerQuery(query).get_return();
			logDTO.setRespTm(df.format(new Date()));
			logDTO.setRespXml(LogUtils.writeObject2String(response));
			TransResultEhm  result = response.getTXInsuranceResponseEhm().getTransResultEhm();
			if("1".equals(result.getResultCode())){
				model.put(Constants.CHECK_INFO, "success");
				model.put(Constants.HANDLER_QUERY_INFO, response);
			}
			else {
				model.put(Constants.CHECK_INFO, "fail");
			}
			logDTO.setLogType("success");
		} catch (AxisFault e) {
			logDTO.setLogType("fail");
			logDTO.setExc(e);
			e.printStackTrace();
		} catch (RemoteException e) {
			logDTO.setLogType("fail");
			logDTO.setExc(e);
			e.printStackTrace();
		}
		
		LogUtils.executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				try {
					logService.addLog(logDTO);
				} catch (BusinessException e) {
					e.printStackTrace();
				}	
				
			}
		});	
		
		
		return model;
		
	}
}
