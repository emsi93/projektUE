package system.exchange.curriencies.mvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import system.exchange.curriencies.modules.FormatNumberAccount;
import system.exchange.curriencies.mvc.dao.ExchangeCurrienciesDAOInterface;
import system.exchange.curriencies.mvc.model.BankAccountModel;
import system.exchange.curriencies.mvc.model.NewBankAccountModel;
import system.exchange.curriencies.mvc.model.UserModel;

@Service("ExchangeCurrienciesDAO")
@Scope("singleton")
public class ExchangeCurrienciesDAOImpl implements
		ExchangeCurrienciesDAOInterface {

	@Autowired()
	private ComboPooledDataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings("restriction")
	@PreDestroy
	public void cleanUp() {
		try {
			dataSource.close();
		} catch (Exception e) {
		}
	}

	public void addCompany() throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public void addUser(UserModel userFormModel) throws DataAccessException {

		jdbcTemplate
				.update("INSERT INTO users(name,surname,phone_number,email) VALUES(?,?,?,?)",
						userFormModel.getName(), userFormModel.getSurname(),
						userFormModel.getPhoneNumber(),
						userFormModel.getEmail());
		int id = getUserID(userFormModel.getEmail());
		jdbcTemplate
				.update("INSERT INTO logins(login,password,id_user,role) VALUES(?,?,?)",
						userFormModel.getLogin(), userFormModel.getPassword(),
						id, "ROLE_USER");
	}

	public int getUserID(String email) throws DataAccessException {
		Object[] parameter = { email };
		return jdbcTemplate.queryForObject(
				"SELECT id FROM users WHERE email=?", parameter,
				new RowMapper<Integer>() {

					public Integer mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new Integer(rs.getInt(1));
					}
				});
	}

	public int checkUniqueEmail(String email) throws DataAccessException {
		Object[] parameter = { email };
		return jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM users WHERE email=?", parameter,
				new RowMapper<Integer>() {

					public Integer mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new Integer(rs.getInt(1));
					}
				});
	}

	public int checkUniqueLogin(String login) throws DataAccessException {
		Object[] parameter = { login };
		return jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM logins WHERE login=?", parameter,
				new RowMapper<Integer>() {

					public Integer mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new Integer(rs.getInt(1));
					}
				});
	}

	public List<String> getListCurriencies() throws DataAccessException {
		return jdbcTemplate.query(
				"SELECT iso FROM curriencies ORDER BY iso ASC",
				new RowMapper<String>() {

					public String mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new String(rs.getString(1));
					}
				});
	}

	public List<String> getListCountries() throws DataAccessException {
		return jdbcTemplate.query(
				"SELECT name FROM countries ORDER BY name ASC",
				new RowMapper<String>() {

					public String mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new String(rs.getString(1));
					}
				});
	}

	public int chechkUniqueNumberAccount(String numberAccount)
			throws DataAccessException {
		Object[] parameter = { FormatNumberAccount.changeFormat(numberAccount) };
		return jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM bank_accounts WHERE number_account=?",
				parameter, new RowMapper<Integer>() {

					public Integer mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new Integer(rs.getInt(1));
					}
				});
	}

	public void addBankAccount(NewBankAccountModel newBankAccountModel, int userID)
			throws DataAccessException {
		// TODO Auto-generated method stub
		String countryISO = getCountryISO(newBankAccountModel.getCountry());
		String accountNumber = FormatNumberAccount.changeFormat(newBankAccountModel.getNumberAccount());
		jdbcTemplate
				.update("INSERT INTO bank_accounts(number_account,country,curriency) VALUES(?,?,?)",
						accountNumber, countryISO,
						newBankAccountModel.getCurrency());
		int accountID = getBankAccountID(accountNumber);
		jdbcTemplate.update(
				"INSERT INTO user_accounts(id_login,id_account) VALUES(?,?)",
				userID, accountID);
	}

	public String getCountryISO(String countryName) throws DataAccessException {
		Object[] parameter = { countryName };
		return jdbcTemplate.queryForObject(
				"SELECT iso FROM countries WHERE name=?", parameter,
				new RowMapper<String>() {

					public String mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new String(rs.getString(1));
					}
				});
	}

	public int getBankAccountID(String numberAccount)
			throws DataAccessException {
		Object[] parameter = { numberAccount };
		return jdbcTemplate.queryForObject(
				"SELECT id FROM bank_accounts WHERE number_account=?",
				parameter, new RowMapper<Integer>() {

					public Integer mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new Integer(rs.getInt(1));
					}
				});
	}

	public List<BankAccountModel> getListBankAccounts(int idUser)
			throws DataAccessException {
		return jdbcTemplate
				.query("SELECT bc.number_account, bc.country, bc.curriency FROM bank_accounts bc INNER JOIN user_accounts uc on bc.id = uc.id_account WHERE uc.id_login=?",
						new RowMapper<BankAccountModel>() {

							public BankAccountModel mapRow(ResultSet rs,
									int rowNumber) throws SQLException {
								return new BankAccountModel(rs.getString(1), rs
										.getString(2), rs.getString(3));
							}
						}, new Object[] { idUser });
	}

	public int getLoginIDByLogin(String name) throws DataAccessException {
		Object[] parameter = { name };
		return jdbcTemplate
				.queryForObject(
						"SELECT id FROM logins WHERE login = ?",
						parameter, new RowMapper<Integer>() {

							public Integer mapRow(ResultSet rs, int rowNumber)
									throws SQLException {
								return new Integer(rs.getInt(1));
							}
						});
	}

}
