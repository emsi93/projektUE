package system.exchange.curriencies.mvc.model;

public class NewBankAccountModel {

	private String numberAccount;
	private String country;
	private String currency;

	public NewBankAccountModel(String numberAccount, String country,
			String currency) {
		super();
		this.numberAccount = numberAccount;
		this.country = country;
		this.currency = currency;
	}

	public NewBankAccountModel() {
		this(null, null, null);
	}

	public String getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
