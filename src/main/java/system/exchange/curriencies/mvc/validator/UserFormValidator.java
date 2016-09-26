package system.exchange.curriencies.mvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import system.exchange.curriencies.modules.ValidationUtils;
import system.exchange.curriencies.mvc.dao.ExchangeCurrienciesDAOInterface;
import system.exchange.curriencies.mvc.model.UserFormModel;



@Component("userFormValidator")
@Scope("singleton")
public class UserFormValidator implements Validator {
	
	private static final String OBLIGATORY_FIELD_ERROR_MSG = "Pole jest wymagane.";
	private static final String LOGIN_TOO_LONG = "Login jest za d³ugi.";
	private static final String LOGIN_IS_USED = "Login jest ju¿ u¿yty.";
	private static final String EMAIL_IS_USED = "Adres email jest ju¿ u¿yty.";
	private static final String EMAIL_TOO_LONG = "Adres email jest za d³ugi.";
	private static final String NAME_TOO_LONG = "Imiê jest za d³ugie.";
	private static final String SURNAME_TOO_LONG = "Nazwisko jest za d³ugie.";
	private static final String PASSWORD_TOO_LONG = "Has³o jest za d³ugie.";
	private static final String PASSWORD_TOO_SHORT = "Podane has³o jest za krótkie.";
	private static final String DIFFERENT_PASSWORD = "Has³a nie mog¹ siê ró¿niæ.";
	private static final String ERROR_PHONE_NUMBER = "Numer telefonu mo¿e zawieraæ jedynie cyfry.";
	
	
	@Autowired
	private ExchangeCurrienciesDAOInterface dao;
	
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
		
		ValidationUtils.rejectIfTooLong(errors, "name",
				userFormModel.getName(), 20, NAME_TOO_LONG);
		ValidationUtils.rejectIfTooLong(errors, "surname",
				userFormModel.getSurname(), 20, SURNAME_TOO_LONG);
		ValidationUtils.rejectIfTooLong(errors, "login",
				userFormModel.getLogin(), 10, LOGIN_TOO_LONG);
		ValidationUtils.rejectIfTooLong(errors, "password",
				userFormModel.getPassword(), 20, PASSWORD_TOO_LONG);
		ValidationUtils.rejectIfTooLong(errors, "email",
				userFormModel.getEmail(), 50, EMAIL_TOO_LONG);
		
		if(userFormModel.getPassword().length()<8 && userFormModel.getPassword().length()>0)
			ValidationUtils.reject(errors, "password", PASSWORD_TOO_SHORT);
		if(!userFormModel.getPassword().equals(userFormModel.getPassword2()))
			ValidationUtils.reject(errors, "password2", DIFFERENT_PASSWORD);
		if (!userFormModel.getPhoneNumber().matches("[0-9]")
				&& userFormModel.getPhoneNumber().length() > 0)
			ValidationUtils.reject(errors, "phoneNumber", ERROR_PHONE_NUMBER);
		
		int param1 = dao.checkUniqueEmail(userFormModel.getEmail());
		int param2 = dao.checkUniqueLogin(userFormModel.getLogin());
		
		if(param1==1)
			ValidationUtils.reject(errors, "email", EMAIL_IS_USED);
		if(param2==1)
			ValidationUtils.reject(errors, "login", LOGIN_IS_USED);
			
		
	}
}
