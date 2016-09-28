package system.exchange.curriencies.mvc.model;

public class BankAccountModel {

	private String numberAccount;
	private String country;
	private String carrency;
	public BankAccountModel(String numberAccount, String country,
			String carrency) {
		super();
		this.numberAccount = numberAccount;
		this.country = country;
		this.carrency = carrency;
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
	public String getCarrency() {
		return carrency;
	}
	public void setCarrency(String carrency) {
		this.carrency = carrency;
	}
	@Override
	public String toString() {
		return "BankAccountModel [numberAccount=" + numberAccount
				+ ", country=" + country + ", carrency=" + carrency + "]";
	}
	
	
	
}
