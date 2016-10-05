package com.sone.dao;

import java.util.List;

import com.sone.exceptions.SoneDataException;
import com.sone.freshman.dto.AddressDTO;
import com.sone.freshman.utils.Messages;


public interface AddressDao {
	List<com.sone.freshman.dto.AddressDTO> getList()throws SoneDataException;
	Messages save(AddressDTO dto)throws SoneDataException;
	Messages update(AddressDTO dto)throws SoneDataException;
	AddressDTO get(int id)throws SoneDataException;
}
