package com.sone.freshman.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sone.exceptions.SoneWebException;
import com.sone.freshman.bu.AddressManager;
import com.sone.freshman.utils.Messages;
import com.sone.freshman.vo.AddressVO;
@Controller
public class Address {
	@Autowired AddressManager addressMgr;
	public void setAddressMgr(AddressManager addressMgr) {
		this.addressMgr = addressMgr;
	}
	@RequestMapping(value="/address",method = RequestMethod.GET)
	public ModelAndView read() {
		ModelAndView view=new ModelAndView("address");
		List<AddressVO> voList=null;
		try {
			voList = addressMgr.getList();
		} catch (SoneWebException e) {
			e.printStackTrace();
		}
		view.addObject("listOfAddress", voList);
		return view;
	}
	@RequestMapping(value="/address/add",method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("address") AddressVO vo,BindingResult  errors,HttpServletRequest req) {
		Messages msg=null;
		try {
			msg = addressMgr.save(vo);
		} catch (SoneWebException e) {
			e.printStackTrace();
		}
		if (msg.getMessageType().equals("INFO")){
			return "redirect:/address";
		}else{
			ObjectError err=new ObjectError("",msg.get(0));
			errors.addError(err);
		}
		return "redirect:/address";
	}
	@RequestMapping(value="/address/add",method = RequestMethod.GET)
	public ModelAndView save() {
		ModelAndView view=new ModelAndView("address/add");
		AddressVO vo=null;
		try {
			vo = new AddressVO(addressMgr.getMaxId()+1);
		} catch (SoneWebException e) {
			e.printStackTrace();
		}
		view.addObject("address", vo);
		return view;
	}
	@RequestMapping(value="/address/update",method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute("address") AddressVO vo,BindingResult  errors,HttpServletRequest req) {
		Messages msg=null;
		try {
			msg = addressMgr.update(vo);
		} catch (SoneWebException e) {
			e.printStackTrace();
		}
		if (msg.getMessageType().equals("INFO")){
			return "redirect:/address";
		}else{
			ObjectError err=new ObjectError("",msg.get(0));
			errors.addError(err);
		}
		return "redirect:/address";
	}
	@RequestMapping(value="/address/update{id}",method = RequestMethod.GET)
	public ModelAndView update(@PathVariable int id) {
		ModelAndView view=new ModelAndView("address/update");
		AddressVO vo=null;
		try {
			vo=addressMgr.get(id);
		} catch (SoneWebException e) {
			e.printStackTrace();
		}
		view.addObject("address", vo);
		return view;
	}
}
