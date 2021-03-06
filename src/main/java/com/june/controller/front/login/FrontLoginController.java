package com.june.controller.front.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.june.common.BaseController;
import com.june.common.Constants;
import com.june.dto.front.login.UserInfoDto;
import com.june.service.front.login.FrontLoginService;

@Controller
@RequestMapping("/frontLogin")
public class FrontLoginController extends BaseController<UserInfoDto>{

	@Autowired
	FrontLoginService frontLoginService;
	
	@RequestMapping("/")
	public ModelAndView frontLogin()
	{
		ModelAndView modelAndView = null;
		
		modelAndView = new ModelAndView("front/login");
		return modelAndView;
	}
	@RequestMapping("/main")
	public ModelAndView frontLoginto(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		ModelAndView result = null;
		String userid = request.getParameter("username");
	    String password = request.getParameter("password");
	    UserInfoDto userInfoDto = new UserInfoDto();
	    userInfoDto.setUserId(userid);
	    userInfoDto.setUserPassword(password);
	    //获取用户信息
	    userInfoDto = frontLoginService.frontloginCheck(userInfoDto);
	    //判断用户是否存在
	      if (userInfoDto == null) {
			  //用户不存在
	    	  result = new ModelAndView("front/login");
            //用户不存在，去出错误信息返回
            String error = Constants.USER_NOT_EXIT;//MessageUtil.$VALUE("user_not_exist");
            result.addObject("error", error);
            return result;
	      }else if (userInfoDto.getUserLock().equals("1")) {
	    	//用户被锁定
	    	  result = new ModelAndView("front/login");
	    	//用户被锁定，取出错误信息返回
            String error = Constants.USER_LOCKED;// MessageUtil.$VALUE("user_locked");
            result.addObject("error", error);
            return result;
	      }else{
	    	  request.getSession().setAttribute("frontLogin","success");
	    	  request.getSession().setAttribute("frontuserid",userInfoDto.getUserId());
	    	  //result.addObject("userid", userInfoDto.getUserId());
	    	  result = new ModelAndView("front/front");
	      }
		return result;
	}
	
	//门户首页退出登录
	@RequestMapping("/frontlogout")
	public ModelAndView frontlogout(HttpServletRequest request,HttpServletResponse response)
	{
		
		ModelAndView result = null;
		request.getSession().removeAttribute("frontuserid");
		request.getSession().removeAttribute("frontLogin");
		result = new ModelAndView("front/front");
		return result;
	}
}
