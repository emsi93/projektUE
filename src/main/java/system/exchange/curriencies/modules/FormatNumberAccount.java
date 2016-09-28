package system.exchange.curriencies.modules;

public class FormatNumberAccount {

	public static String changeFormat(String bankAccount)
	{
		bankAccount = bankAccount.replaceAll("\\s", "");
		bankAccount = bankAccount.substring(0,2)+ " " + bankAccount.substring(2,bankAccount.length());
		bankAccount = bankAccount.substring(0,7)+ " " + bankAccount.substring(7,bankAccount.length());
		bankAccount = bankAccount.substring(0,12)+ " " + bankAccount.substring(12,bankAccount.length());
		bankAccount = bankAccount.substring(0,17)+ " " + bankAccount.substring(17,bankAccount.length());
		bankAccount = bankAccount.substring(0,22)+ " " + bankAccount.substring(22,bankAccount.length());
		bankAccount = bankAccount.substring(0,27)+ " " + bankAccount.substring(27,bankAccount.length());
		return bankAccount;
	}
}
