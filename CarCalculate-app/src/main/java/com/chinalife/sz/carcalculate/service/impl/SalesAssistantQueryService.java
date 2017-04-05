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
import com.chinalife.sz.carcalculate.webservice.SalesAssistantQueryServiceStub;
import com.chinalife.sz.carcalculate.webservice.SalesAssistantQueryServiceStub.BusinessNatureEhm;
import com.chinalife.sz.carcalculate.webservice.SalesAssistantQueryServiceStub.IInsuranceExtensionEhm;
import com.chinalife.sz.carcalculate.webservice.SalesAssistantQueryServiceStub.SalesAssistantEhmRequest;
import com.chinalife.sz.carcalculate.webservice.SalesAssistantQueryServiceStub.SalesAssistantEhmResponse;
import com.chinalife.sz.carcalculate.webservice.SalesAssistantQueryServiceStub.SalesAssistantQuery;
import com.chinalife.sz.carcalculate.webservice.SalesAssistantQueryServiceStub.TXInsuranceRequestEhm;
import com.chinalife.sz.carcalculate.webservice.SalesAssistantQueryServiceStub.TXInsuranceRequestExtensionEhm;
import com.chinalife.sz.carcalculate.webservice.SalesAssistantQueryServiceStub.TransResultEhm;
import com.chinalife.sz.cc.log.service.LogService;
import com.chinalife.sz.cc.model.common.Constants;
import com.chinalife.sz.cc.model.log.LogDTO;
import com.prs.framework.core.exception.BusinessException;

public class SalesAssistantQueryService {
	@Resource
	private LogService logService;
	
	public Map<String,Object> check(String handler1Code){
		final LogDTO logDTO = new LogDTO();
		Map<String, Object> model = new HashMap<String, Object>();
		logDTO.setServiceNme("获取销售人员附加信息");
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
				
				SalesAssistantEhmRequest request = new SalesAssistantEhmRequest();
				request.setTXInsuranceRequestEhm(requestEhm);
				request.setTXInsuranceRequestExtensionEhm(extensionEhm);
				request.setRequestType("SZ0");
				request.setLogonRole("1");
				request.setHandler1Code(handler1Code);
				
				SalesAssistantQuery query = new SalesAssistantQuery();
				query.setEhmRequest(request);
				SalesAssistantEhmResponse response;
				try {
					logDTO.setReqTm(df.format(new Date()));
					logDTO.setReqXml(LogUtils.writeObject2String(request));
					response = new SalesAssistantQueryServiceStub().salesAssistantQuery(query).get_return();
					logDTO.setRespTm(df.format(new Date()));
					logDTO.setRespXml(LogUtils.writeObject2String(response));
					//得到返回结果
					TransResultEhm result = response.getTXInsuranceResponseEhm().getTransResultEhm();
					if("1".equals(result.getResultCode())){
						model.put(Constants.CHECK_INFO, "success");
						model.put(Constants.SALES_ASSISTANT_INFO, response);
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
