package br.com.teste.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teste.model.request.SateliteRequest;

@Service
public class SateliteService {

	public SateliteRequest buscarById(int id) {	
		RestTemplate restTemp = new RestTemplateBuilder()
				.rootUri("https://api.wheretheiss.at/v1/satellites")
				.build();
		
		SateliteRequest satelite = restTemp.getForObject("/{id}", SateliteRequest.class, id);
		return satelite;
	}
}
