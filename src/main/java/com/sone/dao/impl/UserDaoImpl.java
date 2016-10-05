package com.sone.dao.impl;

import java.util.List;

import com.sone.Constants;
import com.sone.dao.UserDao;
import com.sone.exceptions.SoneDataException;
import com.sone.freshman.dto.UserDTO;
import com.sone.freshman.utils.Database;
import com.sone.freshman.utils.Messages;

public class UserDaoImpl implements UserDao {

	@Override
	public List<UserDTO> getList() throws SoneDataException {		
		return Database.getUsersList();
	}

	@Override
	public Messages save(UserDTO dto) throws SoneDataException {
		Database.save(dto);
		Messages msg= new Messages("INFO","Save successful");  
		return msg;
	}

	@Override
	public Messages update(UserDTO dto) throws SoneDataException {
		Database.update(dto);
		Messages msg= new Messages("INFO","Update successful"); 
		return msg;
	}

	@Override
	public UserDTO get(String un) throws SoneDataException {
		UserDTO user=Database.getUser(un);
		return user;
	}

}
