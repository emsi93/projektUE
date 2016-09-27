package system.exchange.curriencies.mvc.model;

public class UserModel {

	private String name;
	private String surname;
	private String login;
	private String password;
	private String password2;
	private String phoneNumber;
	private String email;
	public UserModel(String name, String surname, String login,
			String password, String password2, String phoneNumber, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.password2 = password2;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public UserModel(){
		this(null,null,null,null,null,null,null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}	

