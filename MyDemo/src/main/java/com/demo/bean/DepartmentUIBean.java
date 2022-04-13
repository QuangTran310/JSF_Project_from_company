package com.demo.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.demo.model.Department;
import com.demo.model.Employee;
import com.demo.resources.dao.DepartmentDAO;

@Named(value = "departmentUIBean")
@SessionScoped
public class DepartmentUIBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8108283581187136872L;
	
	@Inject
	DepartmentDAO departmentDAO;

	private Department department = new Department();

	private List<Department> listDepartments;

	private String formCode = "ld";

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public List<Department> getListDepartments() {
		System.out.println("On processing to get list deparments ...");
		this.listDepartments = departmentDAO.getListDepartments();
		return listDepartments;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setCurrentDepartment(Department department) {
		this.department = department;
	}

	public void deleteDepartmentById(Department deparment) {
		System.out.println("On processing to delete deparment ...");
		departmentDAO.deleteDepartment(deparment.getId());
	}

	public void updateDepartmentInfor(AjaxBehaviorEvent aJaxEvent) {
		System.out.println("On processing to update deparment ...");
		if(department.getOther() == null) {
			System.out.println("'other' field value: null");
		}
		System.out.println("'other' field value: " + department.getOther());
		departmentDAO.updateDepartmentInfor(department);
	}

	public void addNewDepartment() {
		System.out.println("On processing to add new deparment ...");
		departmentDAO.insertNewDepartment(department);
	}

	public void createNewDepartment() {
		this.department = new Department();
	}
}
