package com.demo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.demo.model.Employee;
import com.demo.resources.dao.EmployeeDAO;

@Named(value = "employeeUIBean")
@ConversationScoped
public class EmployeeUIBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4461023247428101734L;

	@Inject
	EmployeeDAO employeeDAO;

	private List<Employee> listEmployees;

	private Employee employee = new Employee();

	private String formCode = "le";

//	private Boolean isNewEmployeeAdded;

	@PostConstruct
	public void initBean() {
		System.out.println("Start initiate bean 'employeeUIBean'.");
	}

	@PreDestroy
	public void destroyBean() {
		System.out.println("Destroy bean 'employeeUIBean'.");
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public List<Employee> getListEmployees() {
		listEmployees = employeeDAO.getListEmployees();
		return listEmployees;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setCurrentEmployee(Employee employee) {
		this.employee = employee;
	}

	/*
	 * public Boolean reverseInputTextReadOnlyMode() { return inputTextReadOnlyMode
	 * == true ? false : true; }
	 */

	public void deleteEmployeeById(Employee employee) {
		employeeDAO.deleteEmployeeById(employee.getId());
	}

	public void updateEmployeeInfor(AjaxBehaviorEvent aJaxEvent) {
		employeeDAO.updateEmployeeInfor(employee);
	}

	public void addNewEmployee() {
		employeeDAO.insertNewEmployee(employee);
	}

//	public boolean getIsNewEmployeeAdded() {
//		return isNewEmployeeAdded;
//	}

	public void createNewEmployee() {
		this.employee = new Employee();
	}
}
