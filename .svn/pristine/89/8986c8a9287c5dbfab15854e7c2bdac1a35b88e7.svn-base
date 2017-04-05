package com.chinalife.sz.carcalculate.service.impl;


import com.chinalife.sz.carcalculate.service.WebService;
import com.chinalife.sz.carcalculate.utils.ConfigUtils;
import com.chinalife.sz.carcalculate.webservice.CustomerQueryEhmServiceStub;
import com.chinalife.sz.cc.model.log.LogDTO;
import org.apache.axis2.AxisFault;
import org.springframework.beans.BeanUtils;

import java.rmi.RemoteException;


/**
 * Created by tianwei on 2016/7/22.
 */

public class CustomerQueryService implements WebService {
    private CustomerQueryEhmServiceStub stub;

	@Override
	public <T> boolean checkData(T object) {
		return true;
	}

	@Override
	public <T> T dealData(Object domain, T customerResponse) {
		try {
			stub=new CustomerQueryEhmServiceStub();
			CustomerQueryEhmServiceStub.GetCustomerDetailEhmResponse query = new CustomerQueryEhmServiceStub.GetCustomerDetailEhmResponse();
			CustomerQueryEhmServiceStub.CustomerDetailEhmRequest request = new CustomerQueryEhmServiceStub.CustomerDetailEhmRequest();
			request=ConfigUtils.simpleBeanConvert(domain,request.getClass());
			
			ConfigUtils.setRequest(stub,request);

			query.setRequest(request);
			
			CustomerQueryEhmServiceStub.GetCustomerDetailEhmResponseResponse customerDetailEhmResponse = stub.getCustomerDetailEhmResponse(query);
			CustomerQueryEhmServiceStub.CustomerDetailEhmResponse response = customerDetailEhmResponse.get_return();
			CustomerQueryEhmServiceStub.TransResultEhm result = response.getTXInsuranceResponseEhm().getTransResultEhm();
//			System.out.println(result.getResultCode()+"******************"+result.getResultInfoDesc());
			if(result.getResultCode().equals("1")){
				CustomerQueryEhmServiceStub.PrpDcustomerIdvSchema[] pds = response.getPrpDcustomerIdvSchema();
				//if(pds!=null)
				CustomerQueryEhmServiceStub.PrpDcustomerIdvSchema pd=pds[0];
				BeanUtils.copyProperties(pd,customerResponse);
				return customerResponse;
			}


			return null;


		} catch (AxisFault axisFault) {
			axisFault.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
//		catch (InvocationTargetException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
		return null;
	}

	@Override
	public void asynWtireLog(LogDTO logDTO) {

	}

	public CustomerQueryEhmServiceStub getStub() {
		return stub;
	}

	public void setStub(CustomerQueryEhmServiceStub stub) {
		this.stub = stub;
	}
}
