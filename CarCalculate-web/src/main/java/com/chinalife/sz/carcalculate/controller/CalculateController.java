package com.chinalife.sz.carcalculate.controller;

import com.chinalife.sz.cc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tianwei on 2016/7/18.
 */
@Controller
public class CalculateController {
    @RequestMapping( "hello")
	public String hello(){
		System.out.println("hello");
		return "anjular";
	}
  @RequestMapping(value = "add",method = {RequestMethod.GET,RequestMethod.POST})
	public String addUser( ){
	  System.out.println("add");
	  return "anjular" ;
  }

}
