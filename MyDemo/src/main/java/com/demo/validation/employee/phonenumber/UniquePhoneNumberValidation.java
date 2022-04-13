package com.demo.validation.employee.phonenumber;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.resources.dao.EmployeeDAO;

public class UniquePhoneNumberValidation implements ConstraintValidator<UniquePhoneNumber, String> {
	@Inject
	EmployeeDAO employeeDAO;

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		return employeeDAO.isPhoneNumberExists(phoneNumber) == true ? false : true;
	}

	@Override
	public void initialize(UniquePhoneNumber constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}
}
