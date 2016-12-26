package com.sone.freshman.bu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sone.freshdb.dao.DeptDAO;
import com.sone.freshdb.dto.DeptDTO;
import com.sone.freshdb.dto.EmpDTO;
import com.sone.freshdb.exceptions.FreshDbException;
import com.sone.freshman.bu.DeptService;
import com.sone.freshman.exceptions.FreshmanException;
import com.sone.freshman.vo.DeptVO;
import com.sone.freshman.vo.EmpVO;

@Service(value="deptServ")
public class DeptServiceImpl implements DeptService {

	@Inject private DeptDAO deptDAO;

	@Override
	@Transactional
	public void save(DeptVO vo)throws FreshmanException {
		DeptDTO dto = prepareDto(vo);
		try {
			deptDAO.save(dto);
		} catch (FreshDbException e) {
			throw new FreshmanException(e);
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<DeptVO> getAllDepts() throws FreshmanException{
		List<DeptVO> lstVO = new ArrayList<DeptVO>();
		List<DeptDTO> lstDto;
		try {
			lstDto = deptDAO.getAllDepts();
			for(DeptDTO dto:lstDto){
				lstVO.add(prepareVO(dto));
			}
		} catch (FreshDbException e) {
			throw new FreshmanException(e);
		}		
		return lstVO;
	}
	@Override
	public List<DeptVO> getDepts(DeptVO deptVo) throws FreshmanException {
		List<DeptVO> lstVO = new ArrayList<DeptVO>();
		List<DeptDTO> lstDto;
		try {
			lstDto = deptDAO.getDepts(prepareDto(deptVo));
			for(DeptDTO dto:lstDto){
				lstVO.add(prepareVO(dto));
			}
		} catch (FreshDbException e) {
			throw new FreshmanException(e);
		}
		return lstVO;
	}
	private DeptVO prepareVO(DeptDTO deptDto){
		DeptVO deptVO = null;
		EmpVO empVO = null;

		deptVO=new DeptVO();
		deptVO.setDeptId(deptDto.getDeptId());
		deptVO.setDeptLoc(deptDto.getDeptLoc());
		deptVO.setDeptName(deptDto.getDeptName());
		deptVO.setSid(deptDto.getSid());
		
		for(EmpDTO empDto:deptDto.getEmployees()){
			empVO = new EmpVO();
			empVO.setComm(empDto.getComm());
			empVO.setHireDate(empDto.getHireDate());
			empVO.setId(empDto.getId());
			empVO.setJob(empDto.getJob());
			empVO.setMgr(empDto.getMgr());
			empVO.setName(empDto.getName());
			empVO.setSal(empDto.getSal());
			empVO.setDept(deptVO);
			empVO.setSid(empDto.getSid());
			deptVO.getEmployees().add(empVO);
		}
		return deptVO;
		
	}
	private DeptDTO prepareDto(DeptVO deptVo){
		DeptDTO deptDto = new DeptDTO();
		EmpDTO empDto = null;
		deptDto=new DeptDTO();
		deptDto.setDeptId(deptVo.getDeptId());
		deptDto.setDeptLoc(deptVo.getDeptLoc());
		deptDto.setDeptName(deptVo.getDeptName());
		
		for(EmpVO empVo:deptVo.getEmployees()){
			empDto = new EmpDTO();
			empDto.setComm(empVo.getComm());
			empDto.setHireDate(empVo.getHireDate());
			empDto.setId(empVo.getId());
			empDto.setJob(empVo.getJob());
			empDto.setMgr(empVo.getMgr());
			empDto.setName(empVo.getName());
			empDto.setSal(empVo.getSal());
			empDto.setDept(deptDto);
			deptDto.getEmployees().add(empDto);
		}
		return deptDto;
	}

	
}
