package com.chinalife.sz.carcalculate.service.impl;

import com.chinalife.sz.carcalculate.service.WebService;
import com.chinalife.sz.carcalculate.utils.ConfigUtils;
import com.chinalife.sz.carcalculate.utils.LogUtils;
import com.chinalife.sz.carcalculate.webservice.CarPolicyQueryServiceStub;
import com.chinalife.sz.cc.log.service.LogService;
import com.chinalife.sz.cc.model.log.LogDTO;
import com.prs.framework.core.exception.BusinessException;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tianwei on 2016/7/27.
 */
public class CarPolicyQueryService implements WebService {
	private CarPolicyQueryServiceStub stub;
	private Logger logger= Logger.getLogger(this.getClass());
	@Resource
	private LogService logService;
	@Override
	public <T> boolean checkData(T object) {
		if(object instanceof CarPolicyQueryServiceStub.CarPolicyQueryEhmRequest){
			CarPolicyQueryServiceStub.CarPolicyQueryEhmRequest request=(CarPolicyQueryServiceStub.CarPolicyQueryEhmRequest) object;

			ConfigUtils.setRequest(stub,request);
			return true;
		}
		return false;
	}

	@Override
	public <T> T dealData(Object domain, T carPolicy) {

		try {
			stub =new CarPolicyQueryServiceStub();
			CarPolicyQueryServiceStub.CarPolicyQueryEhmRequest request = new CarPolicyQueryServiceStub.CarPolicyQueryEhmRequest();
			request=ConfigUtils.simpleBeanConvert(domain,request.getClass());
			if(checkData(request)){
				CarPolicyQueryServiceStub.GetPolicyQuery query = new CarPolicyQueryServiceStub.GetPolicyQuery();

				query.setEhmRequest(request);
				
				LogDTO logDTO = new LogDTO();
				logDTO.setCrtUsr(request.getOperator());
				logDTO.setServiceNme("保单查询");
				logDTO.setLicenseNo(request.getLicenseNo());
				logDTO.setFrameNo(request.getFrameNo());
				logDTO.setReqTm(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				String reqXml = LogUtils.writeObject2String(request);
				logDTO.setReqXml(reqXml);
 				CarPolicyQueryServiceStub.CarPolicyQueryEhmResponse response = stub.getPolicyQuery(query).get_return();
				logDTO.setRespTm(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				if(response!=null){
					String respXml=LogUtils.writeObject2String(response);
					logDTO.setRespXml(respXml);
				}
				CarPolicyQueryServiceStub.TransResultEhm result = response.getTXInsuranceResponseEhm().getTransResultEhm();
//				System.out.println(result.getResultInfoDesc());
				if(result.getResultCode().equals("1")){

					logDTO.setLogType("success");
					asynWtireLog(logDTO);
					try {
						CarPolicyQueryServiceStub.CarPolicyQuery[] relationPolicyArr = getRelationPolicyArr(response.getCarPolicyQueryList());
						response.setCarPolicyQueryList(relationPolicyArr);
						carPolicy= (T) ConfigUtils.simpleBeanConvert(response,carPolicy.getClass());
						return carPolicy;
					} catch (ParseException e) {
						e.printStackTrace();
					}

				}
				else {
					logDTO.setLogType("fail");
					logDTO.setErrMsg(result.getResultInfoDesc());
					asynWtireLog(logDTO);
				}
			}

		}  catch (RemoteException e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}

		return null;
	}

	@Override
	public void asynWtireLog(final LogDTO logDTO) {
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
	}
//         得到关联保单数组 Relation
	private CarPolicyQueryServiceStub.CarPolicyQuery[] getRelationPolicyArr(CarPolicyQueryServiceStub.CarPolicyQuery[] carPolicyQueryList) throws ParseException {
		CarPolicyQueryServiceStub.CarPolicyQuery[] carPolicyArr;
		if(carPolicyQueryList!=null){
			if(carPolicyQueryList.length==1){
				carPolicyArr =new CarPolicyQueryServiceStub.CarPolicyQuery[1];
				carPolicyArr[0]= carPolicyQueryList[0];
				return carPolicyArr;
			}else {
				DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
				for(int i=0;i<carPolicyQueryList.length-1;i++){
					for(int j=0;j<carPolicyQueryList.length-1-i;j++){
						if(df.parse(carPolicyQueryList[j].getStartDate()).getTime()>df.parse(carPolicyQueryList[j+1].getStartDate()).getTime()){
							CarPolicyQueryServiceStub.CarPolicyQuery tempCarPolicyQuery=carPolicyQueryList[j];
							carPolicyQueryList[j]=carPolicyQueryList[j+1];
							carPolicyQueryList[j+1]=tempCarPolicyQuery;
						}
						if(df.parse(carPolicyQueryList[j].getStartDate()).getTime()==df.parse(carPolicyQueryList[j+1].getStartDate()).getTime()){
							if(!carPolicyQueryList[j].getRiskCode().equals("0507")){
								CarPolicyQueryServiceStub.CarPolicyQuery tempCarPolicyQuery=carPolicyQueryList[j];
								carPolicyQueryList[j]=carPolicyQueryList[j+1];
								carPolicyQueryList[j+1]=tempCarPolicyQuery;
							}
						}

					}

				}
				CarPolicyQueryServiceStub.CarPolicyQuery[] tempCarPolicyArr=new CarPolicyQueryServiceStub.CarPolicyQuery[2];
				for(int i=carPolicyQueryList.length-1;i>=0;i--){
                    if(!"0507".equals(carPolicyQueryList[i].getRiskCode())){
						tempCarPolicyArr[0]=carPolicyQueryList[i];
						break;
					}
				}
				for(int i=carPolicyQueryList.length-1;i>=0;i--){
					if("0507".equals(carPolicyQueryList[i].getRiskCode())){
						tempCarPolicyArr[1]=carPolicyQueryList[i];
						break;
					}
				}
				if(tempCarPolicyArr[0]!=null&&tempCarPolicyArr[1]!=null){
					carPolicyArr =tempCarPolicyArr;
				}
				else{
					carPolicyArr=new CarPolicyQueryServiceStub.CarPolicyQuery[1];
					if(tempCarPolicyArr[0]!=null){
						carPolicyArr[0]=tempCarPolicyArr[0];
					}
					if(tempCarPolicyArr[1]!=null){
						carPolicyArr[0]=tempCarPolicyArr[1];
					}
				}

				return carPolicyArr;
			}

		}

		return null;
	}
	private CarPolicyQueryServiceStub.CarPolicyQuery getSinglecarPolicy(CarPolicyQueryServiceStub.CarPolicyQuery[] carPolicyQueryList) throws ParseException {
		CarPolicyQueryServiceStub.CarPolicyQuery carPolicy=null;
		if(carPolicyQueryList!=null){
			if(carPolicyQueryList.length==1){
				carPolicy= carPolicyQueryList[0];
				return carPolicy;
			}
			else {
				DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
				for(int i=0;i<carPolicyQueryList.length-1;i++){
					if(df.parse(carPolicyQueryList[i].getStartDate()).getTime()>df.parse(carPolicyQueryList[i+1].getStartDate()).getTime()){
						carPolicyQueryList[i+1]=carPolicyQueryList[i];
					}
					if(df.parse(carPolicyQueryList[i].getStartDate()).getTime()==df.parse(carPolicyQueryList[i+1].getStartDate()).getTime()){
						if(!carPolicyQueryList[i].getRiskCode().equals("0507")){
							carPolicyQueryList[i+1]=carPolicyQueryList[i];
						}
					}
				}
				carPolicy=carPolicyQueryList[carPolicyQueryList.length-1];
			}

		}

		return carPolicy;
	}
	public CarPolicyQueryServiceStub getStub() {
		return stub;
	}

	public void setStub(CarPolicyQueryServiceStub stub) {
		this.stub = stub;
	}


}
