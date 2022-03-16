package webReaderV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {

	public static void main(String[] args) throws IOException {
		// GetUrl();
		PostUrl();
	}
	
	public static void GetUrl() throws IOException {
		URL myUrl = new URL("http://localhost:8080/date");
		HttpURLConnection myConnection = (HttpURLConnection) myUrl.openConnection();
		myConnection.setRequestMethod("GET");
		myConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		int responseCode = myConnection.getResponseCode();
		System.out.println("Response code: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader isr = new BufferedReader(
					new InputStreamReader(
							myConnection.getInputStream()));
			String myText;
			StringBuffer myBuffert = new StringBuffer();
			
			while ( (myText = isr.readLine()) != null  ) {
				myBuffert.append(myText);
			}
			isr.close();
			
			System.out.println(myBuffert.toString());
		} else {
			System.out.println("Could not read URL");
		}
	}

	public static void PostUrl() throws IOException {
		URL myUrl = new URL("http://localhost:8080/datePerson");
		HttpURLConnection myConnection = (HttpURLConnection) myUrl.openConnection();
		myConnection.setRequestMethod("POST");
		myConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

		myConnection.setDoOutput(true);
		OutputStream myOs = myConnection.getOutputStream();
		myOs.write("name=johan".getBytes());
		myOs.flush();
		myOs.close();
		
		int responseCode = myConnection.getResponseCode();
		System.out.println("Response code: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader isr = new BufferedReader(
					new InputStreamReader(
							myConnection.getInputStream()));
			String myText;
			StringBuffer myBuffert = new StringBuffer();
			
			while ( (myText = isr.readLine()) != null  ) {
				myBuffert.append(myText);
			}
			isr.close();
			
			System.out.println(myBuffert.toString());
		} else {
			System.out.println("Could not read URL");
		}
	}

}
