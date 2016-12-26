package com.sone.freshman.bu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sone.freshdb.dao.EmpDAO;
import com.sone.freshdb.dto.DeptDTO;
import com.sone.freshdb.dto.EmpDTO;
import com.sone.freshdb.exceptions.FreshDbException;
import com.sone.freshman.bu.EmpService;
import com.sone.freshman.exceptions.FreshmanException;
import com.sone.freshman.vo.DeptVO;
import com.sone.freshman.vo.EmpVO;

@Service(value="empServ")
@Lazy(value=true)
public class EmpServiceImpl implements EmpService {

	@Inject private EmpDAO empDAO;

	@Override
	@Transactional
	public void save(EmpVO vo)throws FreshmanException {
		EmpDTO dto = prepareDto(vo);
		try {
			empDAO.save(dto);
		} catch (FreshDbException e) {
			throw new FreshmanException(e);
		}
	}

	@Override
	public List<EmpVO> getAllEmps()throws FreshmanException {
		List<EmpVO> lstVO = new ArrayList<EmpVO>();
		List<EmpDTO> lstDto;
		try {
			lstDto = empDAO.getAllEmps();
			for(EmpDTO dto:lstDto){
				lstVO.add(prepareVO(dto));
			}
		} catch (FreshDbException e) {
			throw new FreshmanException(e);
		}
		
		return lstVO;
	}
	
	private EmpVO prepareVO(EmpDTO empDto){
		EmpVO empVo = new EmpVO();
		empVo.setComm(empDto.getComm());
		empVo.setHireDate(empDto.getHireDate());
		empVo.setId(empDto.getId());
		empVo.setJob(empDto.getJob());
		empVo.setMgr(empDto.getMgr());
		empVo.setName(empDto.getName());
		empVo.setSal(empDto.getSal());
		empVo.setSid(empDto.getSid());
		DeptDTO deptDto = empDto.getDept();
		if (deptDto!=null){
			DeptVO deptVo = new DeptVO();
			deptVo.setDeptId(deptDto.getDeptId());
			deptVo.setDeptLoc(deptDto.getDeptLoc());
			deptVo.setDeptName(deptDto.getDeptName());
			deptVo.setSid(deptDto.getSid());
			empVo.setDept(deptVo);
		}
		return empVo;
		
	}
	private EmpDTO prepareDto(EmpVO empVo){
		EmpDTO empDto = new EmpDTO();
		DeptDTO deptDto = null;
		
		empDto.setComm(empVo.getComm());
		empDto.setHireDate(empVo.getHireDate());
		empDto.setId(empVo.getId());
		empDto.setJob(empVo.getJob());
		empDto.setMgr(empVo.getMgr());
		empDto.setName(empVo.getName());
		empDto.setSal(empVo.getSal());
		DeptVO deptVo = empVo.getDept();
		if (deptVo!=null){
			deptDto=new DeptDTO();
			deptDto.setDeptId(deptVo.getDeptId());
			deptDto.setDeptLoc(deptVo.getDeptLoc());
			deptDto.setDeptName(deptVo.getDeptName());
			deptDto.setSid(deptVo.getSid());
			empDto.setDept(deptDto);
		}		
		return empDto;
	}
}
