package com.fgtway.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fgtway.constants.Constants;
import com.fgtway.services.LoginService;
import com.fgtway.utils.Utils;
import com.fgtway.vo.Login;


@Controller
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired private LoginService login;

	@RequestMapping(value = "/logind", method = RequestMethod.GET)
	public ModelAndView logind(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		ModelAndView view=null;
		Map<String, Object> model=new HashMap<String, Object>();
		Login loginVO=new Login();
		loginVO = (Login)session.getAttribute(Constants.LOGIN);
		String un=request.getParameter("uname");		
		if (Utils.isEmpty(un) || Utils.isNull(loginVO)){
			logger.debug("Session not matching");
			loginVO=new Login();
			model.put("loginVO", loginVO);	
			view =  new ModelAndView("login", model);
		}else if (!un.equals(loginVO.getUserName())){
			model.put("loginVO", loginVO);
			view =  new ModelAndView("sessionNotMatch", model);
		}			
		return view;
	}
	@RequestMapping(value = "/logins", method = RequestMethod.POST)
	public ModelAndView logins(@ModelAttribute("loginVO") Login loginVO,BindingResult result) {
		ModelAndView view=null;
		Map<String, Object> model=new HashMap<String, Object>();
		view =  new ModelAndView("welcome", model);
		return view;
	}
}