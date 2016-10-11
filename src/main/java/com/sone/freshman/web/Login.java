package com.sone.freshman.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sone.exceptions.SoneWebException;
import com.sone.freshman.bu.LoginManager;
import com.sone.freshman.utils.MessageCenter;
import com.sone.freshman.utils.Messages;
import com.sone.freshman.vo.UserVO;

@Controller
public class Login implements Validator{
	
	@Autowired private LoginManager loginMgr;
	@Autowired private MessageCenter mc;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request,@ModelAttribute("login") UserVO login) {
		ModelAndView view=new ModelAndView("login");
		HttpSession sess=request.getSession(false);
		if (sess!=null){
			UserVO loginSess = (UserVO)sess.getAttribute("login");
			if (loginSess!=null){
				try {
					boolean result=loginMgr.validateUser(loginSess);
					if (result){
						Messages msg=new Messages();
						msg.add("Welcome to "+loginSess.getUserName());
						request.setAttribute("userDtls", msg);	
						view.setViewName("mainDoor");
					}
				} catch (SoneWebException e) {
					e.printStackTrace();
				}
			}
		}
		
		return view;
	}
	@RequestMapping(value="/validateUser",method = RequestMethod.GET)
	public String processForm(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("login") UserVO login) {
		HttpSession sess=request.getSession(false);
		if (sess!=null){
			sess.invalidate();
		}
		return "redirect:login";
	}
	@RequestMapping(value="validateUser",method = RequestMethod.POST)
	public ModelAndView processForm(@Validated @ModelAttribute("login") UserVO vo,BindingResult  errors,HttpServletRequest req) throws SoneWebException{		
		ModelAndView view=new ModelAndView("login");
		boolean result=false;
		this.validate(vo, errors);
		result = errors.hasErrors() ? false : true ; 
		try {
			if (result){
				result=loginMgr.validateUser(vo);
				if (result){	
					req.getSession().setAttribute("login", vo);
					Messages msg=new Messages();
					msg.add("Welcome "+vo.getUserName());
					req.setAttribute("userDtls", msg);
					view.setViewName("mainDoor");								
				}else{
					ObjectError err=new ObjectError("login", "Invalid login details, Please try again.");
					errors.addError(err);
				}
			}
		} catch (SoneWebException e) {
			throw e;			
		}		
		return view;
	}
	
	@Override
	public boolean supports(Class<?> cls) {
		return UserVO.class.isAssignableFrom(cls);
	}
	@Override
	public void validate(Object arg0, Errors errors) {
		UserVO vo=(UserVO)arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName","err.required",new Object[]{mc.getMessage("username", null)});
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","err.required",new Object[]{mc.getMessage("password", null)});
	}
}