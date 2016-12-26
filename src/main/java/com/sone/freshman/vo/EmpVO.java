package com.sone.freshman.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmpVO {
	private Integer sid;	
	private Integer id;	
	private String name;	
	private String job;	
	private Integer mgr;	
	private Date hireDate;	
	private float sal;	
	private float comm;
	@JsonIgnore
	private DeptVO dept;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public float getComm() {
		return comm;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		EmpVO other = (EmpVO) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public void setDept(DeptVO dept) {
		this.dept = dept;
	}
	public DeptVO getDept() {
		return dept;
	}

	@Override
	public String toString() {
		return "EmpVO [sid=" + sid + ", id=" + id + ", name=" + name + ", job=" + job + ", mgr=" + mgr + ", hireDate="
				+ hireDate + ", sal=" + sal + ", comm=" + comm + ", dept="+ dept +"]";
	}	
	
}
