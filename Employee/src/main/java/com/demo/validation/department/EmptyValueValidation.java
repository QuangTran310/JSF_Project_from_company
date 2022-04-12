package com.demo.validation.department;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "emptyValueValidation")
public class EmptyValueValidation implements Validator {
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String val = (String) value;
		if (val == null) {
			FacesMessage fm = new FacesMessage("This field is required.");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(fm);
		}
	}
}
