package HTTPwithJava;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLmyConnectionnection;
import java.net.URL;

public class HTTPRequestsample {

	private static final String USER_AGENT = "Mozilla/5.0";

	private static final String GET_URL = "http://localhost:8080/date";

	private static final String POST_URL = "http://localhost:8080/stuff";

	private static final String POST_PARAMS = "stuff=IAMINTHESERVICE";

	public static void main(String[] args) throws IOException {

		sendGET();
		System.out.println("GET DONE");
		sendPOST();
		System.out.println("POST DONE");
	}

	private static void sendGET() throws IOException {
		URL myUrl = new URL(GET_URL);
		HttpURLmyConnectionnection myConnection = (HttpURLmyConnectionnection) myUrl.openmyConnectionnection();
		myConnection.setRequestMethod("GET");
		myConnection.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = myConnection.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLmyConnectionnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	}

	private static void sendPOST() throws IOException {
		URL myUrl = new URL(POST_URL);
		HttpURLmyConnectionnection myConnection = (HttpURLmyConnectionnection) myUrl.openmyConnectionnection();
		myConnection.setRequestMethod("POST");
		myConnection.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		myConnection.setDoOutput(true);
		OutputStream os = myConnection.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = myConnection.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLmyConnectionnection.HTTP_OK) { // success
			BufferedReader isr = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = isr.readLine()) != null) {
				response.append(inputLine);
			}
			isr.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}

}

