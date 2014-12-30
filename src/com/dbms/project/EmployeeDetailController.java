package com.dbms.project;

import java.util.List;

import javax.annotation.ManagedBean;

import com.dbms.project.facade.UserContollerImpl;
import com.dbms.vo.EmployeeVO;

/**
 * This class acts as a controller that would get Employee details and populate that in the Employee Details Webpage
 * @author Group 19 SPAR Corp.
 *
 */
@ManagedBean
public class EmployeeDetailController {
	private EmployeeVO employeeVO;
	private List<EmployeeVO> emplDetailsList;
	UserContollerImpl contollerImpl = new UserContollerImpl();
	
	public EmployeeDetailController(){
		employeeVO = new EmployeeVO();
	}

	public String getEmplList(){
		emplDetailsList = contollerImpl.getEmployeeList();
		return "emplDetailsList";
	}
	
	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	public List<EmployeeVO> getEmplDetailsList() {
		return emplDetailsList;
	}

	public void setEmplDetailsList(List<EmployeeVO> emplDetailsList) {
		this.emplDetailsList = emplDetailsList;
	}
}
