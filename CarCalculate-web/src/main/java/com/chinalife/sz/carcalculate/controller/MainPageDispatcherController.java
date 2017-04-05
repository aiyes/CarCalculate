package com.chinalife.sz.carcalculate.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.chinalife.sz.cc.model.common.Constants;
import com.chinalife.sz.cc.model.user.UserInfoDTO;
import com.prs.framework.core.exception.WebControllerException;
import com.prs.framework.core.web.controller.util.WebUtils;

/**
 * 
 * <p>Title: MainPageDispatcherController</p>
 * <p>Description: controller </p>
 * <p>Company: 紫川软件有限公司</p>
 * @author sutanwei@purple-river.com
 * @date 2016年1月16日
 * @version 1.0
 */
@Controller
public class MainPageDispatcherController {

	/**
	 * @Title: 登陆页面
	 * @param request
	 * @param response
	 * @return
	 * @throws WebControllerException
	 */
	//@RequestMapping("login.action")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws WebControllerException {
		try {
			/* session.removeAttribute(LogConstant.LOGIN_MESSAGE);  
			    SystemUserDataBean user = userDao.getSystemUserByUserName(username);  
			    ModelAndView view = null;  
			    if(user == null) {  
			        view = new ModelAndView(new RedirectView("login.html"));  
			        session.setAttribute(LogConstant.LOGIN_MESSAGE, "用户名不正确");  
			        return view;  
			    }  
			    boolean isPasswordCorrect = EncryptionUtil.compareSHA(password, user.getPassword());  
			    if(isPasswordCorrect){  
			        session.setAttribute(LogConstant.CURRENT_USER, username);  
			          
			    } else{  
			        view = new ModelAndView(new RedirectView("login.html"));  
			        session.setAttribute(LogConstant.LOGIN_MESSAGE, "密码不正确");  
			    }  
			          
			    return view;  */			
			
		    //不应该是这样写，但是这样看起来比较容易理解
		    /*String username = request.getParameter("username");
		    String password = request.getParameter("password");
		    User user = getUser(username, password);
		    //保存相应的参数，通过ModelAndView返回
		    Map<String ,Object> model=new HashMap<String,Object>();
		    if(user !=null){
		      model.put("user", user);
		      return new ModelAndView(getSuccessView(),model);
		    }else{
		      model.put("error", "用户名或密码输入错误！！！");
		      return new ModelAndView(getFailView(),model);
		    }	*/			
			
			//Map<String, Object> model = new HashMap<String, Object>();
			//1、收集参数、验证参数  
			//2、绑定参数到命令对象  
			//3、将命令对象传入业务对象进行业务处理  
			//4、选择下一个页面  
			//ModelAndView mv = new ModelAndView();  
			//添加模型数据 可以是任意的POJO对象  
			//mv.addObject("message", "Hello World!");  
			//设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
			//mv.setViewName("login");  
			return new ModelAndView("/login");
		} catch (Exception e) {
			throw new WebControllerException(e);
		}  		
	}	
	
	@RequestMapping(value="login.action",method=RequestMethod.GET)
	public ModelAndView jspLogin(HttpServletRequest request, HttpServletResponse response) throws WebControllerException {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Integer status = (Integer) request.getSession().getAttribute(Constants.STATUS);
			model.put(Constants.STATUS, status);
			
		} catch (Exception e) {
			throw new WebControllerException(e);
		}  	
		return new ModelAndView(new MappingJacksonJsonView(),model);
	}	
	
	/**
	 * @Title: main
	 * @Description: 进入主页
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws WebControllerException
	 */
	@RequestMapping(value="main.action",method=RequestMethod.GET)
	public  ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws WebControllerException {
		try {
			
		//清空cookie
			Cookie[] cookies=request.getCookies();
			
				for(int i=0;i<cookies.length;i++){
					Cookie cookie=new Cookie(cookies[i].getName(), null);
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
		//登陆查询到的信息加入cookie
			UserInfoDTO dto=(UserInfoDTO)request.getSession().getAttribute(Constants.SESSION_USER_INFO);
//			System.out.println(dto.getUserCde());
			Cookie userNme = new Cookie("userName", URLEncoder.encode(dto.getUserNme(), "utf-8"));
			Cookie userCd = new Cookie("userCode",URLEncoder.encode(dto.getUserCde(), "utf-8"));
			response.addCookie(userNme);
			response.addCookie(userCd);
			ModelAndView mvAndView =new ModelAndView("/index");
			return mvAndView;
		} catch(Exception e){
			throw new WebControllerException(e);
		}
	}

	
	/**
	 * 404 ERROR
	 * @param request
	 * @param response
	 * @return
	 * @throws WebControllerException
	 */
	@RequestMapping("error_404.action")
	public ModelAndView error_404(HttpServletRequest request, HttpServletResponse response) throws WebControllerException {
		try {
			return new ModelAndView("/error_404");
		} catch(Exception e){
			throw new WebControllerException(e);
		}
	}
	
	/**
	 * 500 ERROR
	 * @param request
	 * @param response
	 * @return
	 * @throws WebControllerException
	 */
	@RequestMapping("error_500.action")
	public ModelAndView error_500(HttpServletRequest request, HttpServletResponse response) throws WebControllerException {
		try {
			return new ModelAndView("/error_500");
		} catch(Exception e){
			throw new WebControllerException(e);
		}
	}
	
	/**
	 * 403 ERROR
	 * @param request
	 * @param response
	 * @return
	 * @throws WebControllerException
	 */
	@RequestMapping("error_403.action")
	public ModelAndView error_503(HttpServletRequest request, HttpServletResponse response) throws WebControllerException {
		try {
			return new ModelAndView("/error_403");
		} catch(Exception e){
			throw new WebControllerException(e);
		}
	}	

	
}
