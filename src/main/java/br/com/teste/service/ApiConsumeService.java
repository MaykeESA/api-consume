package br.com.teste.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teste.model.request.RickandMortyRequest;
import br.com.teste.model.request.SateliteRequest;

@Service
public class ApiConsumeService {

	public SateliteRequest buscarSateliteById(int id) {	
		RestTemplate restTemp = new RestTemplateBuilder()
				.rootUri("https://api.wheretheiss.at/v1/satellites")
				.build();
		
		return restTemp.getForObject("/{id}", SateliteRequest.class, id);
	}
	
	public RickandMortyRequest buscarRickMortyById(int id) {
		RestTemplate restTemp = new RestTemplateBuilder()
				.rootUri("https://rickandmortyapi.com/api/character")
				.build();
		
		return restTemp.getForObject("/{id}", RickandMortyRequest.class, id);
	}
}
