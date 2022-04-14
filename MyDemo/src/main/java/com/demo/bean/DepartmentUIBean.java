package com.demo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.demo.model.Department;
import com.demo.model.Employee;
import com.demo.resources.dao.DepartmentDAO;

@Named(value = "departmentUIBean")
@ConversationScoped
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

	@PostConstruct
	public void initBean() {
		System.out.println("Start initiate bean 'departmentUIBean'.");
	}

	@PreDestroy
	public void destroyBean() {
		System.out.println("Destroy bean 'departmentUIBean'.");
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public List<Department> getListDepartments() {
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
		departmentDAO.deleteDepartment(deparment.getId());
	}

	public void updateDepartmentInfor(AjaxBehaviorEvent aJaxEvent) {
		departmentDAO.updateDepartmentInfor(department);
	}

	public void addNewDepartment() {
		departmentDAO.insertNewDepartment(department);
	}

	public void createNewDepartment() {
		this.department = new Department();
	}
}
