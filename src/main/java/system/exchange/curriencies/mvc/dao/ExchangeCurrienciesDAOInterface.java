package system.exchange.curriencies.mvc.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import system.exchange.curriencies.mvc.model.UserFormModel;


public interface ExchangeCurrienciesDAOInterface {

	public void addCompany() throws DataAccessException;
	
	public void addUser(UserFormModel userFormModelOrNull) throws DataAccessException;
	
	public int getUserID(String email) throws DataAccessException;
	
	public int checkUniqueEmail(String email) throws DataAccessException;
	
	public int checkUniqueLogin(String login)throws DataAccessException;
	
	public List<String> getListCurriencies() throws DataAccessException;
}
