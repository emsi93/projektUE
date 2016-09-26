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

import system.exchange.curriencies.mvc.dao.ExchangeCurrienciesDAOInterface;
import system.exchange.curriencies.mvc.model.UserFormModel;

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

	public void addUser(UserFormModel userFormModel) throws DataAccessException {

		jdbcTemplate
				.update("INSERT INTO users(name,surname,phone_number,email) VALUES(?,?,?,?)",
						userFormModel.getName(), userFormModel.getSurname(),
						userFormModel.getPhoneNumber(),
						userFormModel.getEmail());
		int id = getUserID(userFormModel.getEmail());
		jdbcTemplate.update("INSERT INTO logins(login,password,id_user) VALUES(?,?,?)",
				userFormModel.getLogin(), userFormModel.getPassword(), id);
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
		Object[] parameter = {email};
		return jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM users WHERE email=?",
				parameter, new RowMapper<Integer>() {

					public Integer mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new Integer(rs.getInt(1));
					}
				});
	}

	public int checkUniqueLogin(String login) throws DataAccessException {
		Object[] parameter = {login};
		return jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM logins WHERE login=?",
				parameter, new RowMapper<Integer>() {

					public Integer mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new Integer(rs.getInt(1));
					}
				});
	}

	public List<String> getListCurriencies() throws DataAccessException {
		return jdbcTemplate
				.query("SELECT iso FROM curriencies ORDER BY iso ASC",
						new RowMapper<String>() {

							public String mapRow(ResultSet rs,
									int rowNumber) throws SQLException {
								return new String(rs.getString(1));
							}
						});
	}

}
