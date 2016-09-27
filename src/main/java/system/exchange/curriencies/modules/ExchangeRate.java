package system.exchange.curriencies.modules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ExchangeRate {

	public static String getRate(String currency1, String currency2) throws IOException
	{
		String url = "http://api.fixer.io/latest?base="+currency2;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String string = response.toString();
		JSONObject json = new JSONObject(string);
		JSONObject json2 = new JSONObject(json.get("rates").toString());
		return json2.get(currency1).toString();
	}
}
