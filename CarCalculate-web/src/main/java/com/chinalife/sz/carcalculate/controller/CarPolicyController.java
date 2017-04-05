package com.chinalife.sz.carcalculate.controller;

import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;


/**
 * 车辆保单数据查询接口调用
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinalife.sz.cc.domain.CarPolicyResponse;
import com.chinalife.sz.cc.domain.CarPolicyRequest;

/**
 * 
 * @author MarsCheng
 *
 */

@Controller
@RequestMapping("/show")
public class CarPolicyController {
	
	
	@RequestMapping(value= "/execute",method=RequestMethod.POST)
	public @ResponseBody CarPolicyResponse CarPolicyRequest(CarPolicyRequest request) {

			
			
			
			

		
		return null;

	}

}
