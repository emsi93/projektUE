package system.exchange.curriencies.mvc.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import system.exchange.curriencies.modules.ValidationUtils;
import system.exchange.curriencies.mvc.model.UserFormModel;



@Component("userFormValidator")
@Scope("singleton")
public class UserFormValidator implements Validator {
	
	private static final String OBLIGATORY_FIELD_ERROR_MSG = "Pole jest wymagane.";
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserFormModel.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserFormModel userFormModel = (UserFormModel) target;
		
		ValidationUtils.rejectIfEmpty(errors, "name",
				OBLIGATORY_FIELD_ERROR_MSG);
		ValidationUtils.rejectIfEmpty(errors, "surname",
				OBLIGATORY_FIELD_ERROR_MSG);
		ValidationUtils.rejectIfEmpty(errors, "login",
				OBLIGATORY_FIELD_ERROR_MSG);
		ValidationUtils.rejectIfEmpty(errors, "password",
				OBLIGATORY_FIELD_ERROR_MSG);
		ValidationUtils.rejectIfEmpty(errors, "password2",
				OBLIGATORY_FIELD_ERROR_MSG);
		ValidationUtils.rejectIfEmpty(errors, "phoneNumber",
				OBLIGATORY_FIELD_ERROR_MSG);
		ValidationUtils.rejectIfEmpty(errors, "email",
				OBLIGATORY_FIELD_ERROR_MSG);
	}
}
