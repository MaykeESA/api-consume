package br.com.teste.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConnectionService {

	private String url;
	private HttpClient client;

	public ConnectionService(String url) {
		this.url = url;
	}
	
	public HttpResponse<String> getServerResponse() throws URISyntaxException, IOException, InterruptedException {
		this.client = HttpClient.newBuilder().build();
		HttpRequest req = this.getClientRequest();
		HttpResponse<String> response = this.client.send(req, BodyHandlers.ofString());
		
		return response;
	}
	
	private HttpRequest getClientRequest() throws URISyntaxException {
		URI uri = new URI(this.url);

		HttpRequest request = HttpRequest.newBuilder()
				.uri(uri)
				.GET()
				.build();

		return request;
	}

}
