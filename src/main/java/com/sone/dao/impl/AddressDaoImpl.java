package com.sone.dao.impl;

import java.util.List;

import com.sone.dao.AddressDao;
import com.sone.exceptions.SoneDataException;
import com.sone.freshman.dto.AddressDTO;
import com.sone.freshman.utils.Database;
import com.sone.freshman.utils.Messages;

public class AddressDaoImpl implements AddressDao {

	@Override
	public List<AddressDTO> getList() throws SoneDataException {
		return Database.getAddressList();
	}

	@Override
	public Messages save(AddressDTO dto) throws SoneDataException {
		Database.save(dto);
		Messages msg= new Messages("INFO","Save successful");
		return msg;
	}

	@Override
	public Messages update(AddressDTO dto) throws SoneDataException {
		Database.update(dto);
		Messages msg= new Messages("INFO","Update successful");
		return msg;
	}

	@Override
	public AddressDTO get(int id) throws SoneDataException {
		AddressDTO address=Database.getAddress(id);
		return address;
	}
}
