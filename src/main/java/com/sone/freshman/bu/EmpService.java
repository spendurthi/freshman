package com.sone.freshman.bu;

import java.util.List;

import com.sone.freshman.exceptions.FreshmanException;
import com.sone.freshman.vo.EmpVO;


public interface EmpService {

	void save(EmpVO dept)throws FreshmanException;
	List<EmpVO> getAllEmps()throws FreshmanException;
}
