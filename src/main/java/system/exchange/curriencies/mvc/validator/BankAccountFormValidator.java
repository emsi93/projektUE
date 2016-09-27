package system.exchange.curriencies.mvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import system.exchange.curriencies.modules.ValidationUtils;
import system.exchange.curriencies.mvc.dao.ExchangeCurrienciesDAOInterface;
import system.exchange.curriencies.mvc.model.NewBankAccountModel;
@Component("bankAccountFormValidator")
@Scope("singleton")
public class BankAccountFormValidator implements Validator {

	
	private static final String NUMBER_ACCOUNT_TOO_LONG = "Numer konta jest za d³ugi.";
	private static final String NUMBER_ACCOUNT_TOO_SHORT = "Numer konta jest za krótki.";
	private static final String NUMBER_ACCOUNT_IS_USED = "Podany numer jest ju¿ u¿yty";
	//private static final String NUMBER_ACCOUNT_INVALID = "Podany numer jest nieprawid³owy.";
	private static final String NUMBER_ACCOUNT_CONTAINS_LETTERS = "Numer konta musi sk³adaæ siê jedynie z cyfr.";
	private static final String OBLIGATORY_FIELD_ERROR_MSG = "Pole nie mo¿e byæ puste.";
	@Autowired
	private ExchangeCurrienciesDAOInterface dao;
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return NewBankAccountModel.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		NewBankAccountModel newBankAccountModel = (NewBankAccountModel) target;
		
		ValidationUtils.rejectIfEmpty(errors, "numberAccount",
				OBLIGATORY_FIELD_ERROR_MSG);
		
		if(newBankAccountModel.getNumberAccount().replaceAll("\\s", "").length()>26)
			ValidationUtils.reject(errors,"numberAccount",NUMBER_ACCOUNT_TOO_LONG);
		if(newBankAccountModel.getNumberAccount().replaceAll("\\s", "").length()<26)
			ValidationUtils.reject(errors,"numberAccount",NUMBER_ACCOUNT_TOO_SHORT);
		if (newBankAccountModel.getNumberAccount().replaceAll("\\s", "").matches("[0-9]"))
			ValidationUtils.reject(errors,"numberAccount",NUMBER_ACCOUNT_CONTAINS_LETTERS);
		if(newBankAccountModel.getCountry().equals(""))
			ValidationUtils.reject(errors,"country",OBLIGATORY_FIELD_ERROR_MSG);
		if(newBankAccountModel.getCurrency().equals(""))
			ValidationUtils.reject(errors,"currency",OBLIGATORY_FIELD_ERROR_MSG);
		
		int param1 = dao.chechkUniqueNumberAccount(newBankAccountModel.getNumberAccount());
		if(param1==1)
			ValidationUtils.reject(errors,"numberAccount",NUMBER_ACCOUNT_IS_USED);
	}

}
