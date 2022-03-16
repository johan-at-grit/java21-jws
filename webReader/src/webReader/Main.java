package webReader;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
 
public class Main {
    public static void main(String[] args) {
        var request = HttpRequest
        		.newBuilder(
        				URI.create("http://localhost:8080/datePerson?name=johan"))
                .GET()
                .build();
 
        HttpClient.newHttpClient()
                .sendAsync(
                		request, 
                		HttpResponse
                			.BodyHandlers
                			.ofString(Charset.defaultCharset()))
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
