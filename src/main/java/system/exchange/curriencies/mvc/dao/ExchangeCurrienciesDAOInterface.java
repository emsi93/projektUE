package system.exchange.curriencies.mvc.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import system.exchange.curriencies.mvc.model.NewBankAccountModel;
import system.exchange.curriencies.mvc.model.UserModel;


public interface ExchangeCurrienciesDAOInterface {

	public void addCompany() throws DataAccessException;
	
	public void addUser(UserModel userFormModel) throws DataAccessException;
	
	public void addBankAccount(NewBankAccountModel newBankAccountModel)throws DataAccessException;
	
	public int getUserID(String email) throws DataAccessException;
	
	public int getBankAccountID(String numberAccount)throws DataAccessException;
	
	public int checkUniqueEmail(String email) throws DataAccessException;
	
	public int checkUniqueLogin(String login)throws DataAccessException;
	
	public int chechkUniqueNumberAccount(String numberAccount) throws DataAccessException;
	
	public List<String> getListCurriencies() throws DataAccessException;
	
	public List<String> getListCountries() throws DataAccessException;
	
	public String getCountryISO(String countryName) throws DataAccessException;
	
	
	
}
