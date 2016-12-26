package com.sone.freshman.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DeptVO {
	private Integer sid;	
	private Integer deptId;	
	private String deptName;	
	private String deptLoc;
	@JsonIgnore
	private List<EmpVO> employees = new ArrayList<EmpVO>(0);
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeptVO other = (DeptVO) obj;
		if (deptId != other.deptId)
			return false;
		return true;
	}
	public void setEmployees(List<EmpVO> employees) {
		this.employees = employees;
	}
	public List<EmpVO> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return "DeptVO [sid=" + sid + ", deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]";
	}
	
}
