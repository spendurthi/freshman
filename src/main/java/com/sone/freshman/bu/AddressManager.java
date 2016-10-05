package com.sone.freshman.bu;

import java.util.List;

import com.sone.exceptions.SoneWebException;
import com.sone.freshman.utils.Messages;
import com.sone.freshman.vo.AddressVO;
public interface AddressManager {
	List<AddressVO> getList()throws SoneWebException;
	Messages save(AddressVO vo)throws SoneWebException;
	Messages update(AddressVO vo)throws SoneWebException;
	AddressVO get(int id)throws SoneWebException;
}
