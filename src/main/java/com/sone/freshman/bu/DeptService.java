package com.sone.freshman.bu;

import java.util.List;

import com.sone.freshman.exceptions.FreshmanException;
import com.sone.freshman.vo.DeptVO;


public interface DeptService {

	void save(DeptVO dept) throws FreshmanException;
	List<DeptVO> getAllDepts()throws FreshmanException;
	List<DeptVO> getDepts(DeptVO dept)throws FreshmanException;
}
