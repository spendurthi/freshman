package com.sone.freshman.bu.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sone.dao.UserDao;
import com.sone.exceptions.SoneDataException;
import com.sone.exceptions.SoneWebException;
import com.sone.freshman.bu.LoginManager;
import com.sone.freshman.dto.UserDTO;
import com.sone.freshman.vo.UserVO;

public class LoginManagerImpl implements LoginManager {
	
	@Autowired UserDao dao;
	public boolean validateUser(UserVO user) throws SoneWebException{
		boolean result = false;
		try {
			UserDTO usr= dao.get(user.getUserName());
			if (usr==null){
				result  =false;
			}else{
				result = usr.getPassword().equals(user.getPassword());
			}							
		} catch (SoneDataException e) {
			e.printStackTrace();
			result  =false;
		}
		return result;
	}
}
