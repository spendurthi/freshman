package com.sone.dao;

import java.util.List;

import com.sone.exceptions.SoneDataException;
import com.sone.freshman.dto.UserDTO;
import com.sone.freshman.utils.Messages;

public interface UserDao {

	List<UserDTO> getList()throws SoneDataException;
	Messages save(UserDTO dto)throws SoneDataException;
	Messages update(UserDTO dto)throws SoneDataException;
	UserDTO get(String un)throws SoneDataException;

}
