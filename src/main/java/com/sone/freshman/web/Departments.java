package com.sone.freshman.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sone.freshman.bu.DeptService;
import com.sone.freshman.exceptions.FreshmanException;
import com.sone.freshman.vo.DeptVO;

@Controller(value="departments")
@Scope(value="request")
public class Departments {
	@Inject private DeptService deptSvc;
	public void setDeptSvc(DeptService deptSvc) {
		this.deptSvc = deptSvc;
	}
	public DeptService getDeptSvc() {
		return deptSvc;
	}
	@RequestMapping(value = "/dept/search{deptId}/dn{deptname}/dl{deptLoc}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeptVO>>  search(@PathVariable("deptId") String deptId,@PathVariable("deptname") String deptName,@PathVariable("deptLoc") String deptLoc){
		DeptVO voLcl = new DeptVO();
		if (deptId!=null && deptId.length()>0){
				voLcl.setDeptId(Integer.valueOf(deptId));
		}
		if (deptName!=null && deptName.length()>0){
			voLcl.setDeptName(deptName);
		}
		if (deptLoc!=null && deptLoc.length()>0){
			voLcl.setDeptLoc(deptLoc);
		}
		
		List<DeptVO> srchDepts=null;
		try {
			srchDepts = deptSvc.getDepts(voLcl);
		} catch (FreshmanException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<DeptVO>>(srchDepts, HttpStatus.OK);
	}
	@RequestMapping(value="/dept/search",method = RequestMethod.GET)
	public ModelAndView search() {
		ModelAndView view=new ModelAndView("dept/search");
		DeptVO vo = new DeptVO();		
		view.addObject("dept", vo);
		return view;
	}
}
