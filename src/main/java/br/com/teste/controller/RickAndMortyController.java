package br.com.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import br.com.teste.model.request.RickandMortyRequest;
import br.com.teste.service.ApiConsumeService;

@RestController
public class RickAndMortyController {

	@Autowired
	private ApiConsumeService apiConsumeService;
	
	// Traz dados da Api do Rick and Morty, através do ID do personagem
	@GetMapping("/rick-morty/{id}")
	public ResponseEntity<RickandMortyRequest> buscarById(@PathVariable int id){
		try {
			RickandMortyRequest request = this.apiConsumeService.buscarRickMortyById(id);
			return ResponseEntity.ok(request);
		}catch(HttpClientErrorException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
