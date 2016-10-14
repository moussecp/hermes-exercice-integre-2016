package com.hermes_ecs.java_exercise.controller.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hermes_ecs.java_exercise.controller.dto.BuyerForm;

public class BuyerFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BuyerForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstname.required");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "lastname.required");
	}

	
	
}
