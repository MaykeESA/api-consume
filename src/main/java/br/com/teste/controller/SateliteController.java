package br.com.teste.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.teste.model.bd.Satelite;
import br.com.teste.model.dto.SateliteDto;
import br.com.teste.model.request.SateliteRequest;
import br.com.teste.repository.SateliteRepository;
import br.com.teste.service.ApiConsumeService;

@RestController
public class SateliteController {
	
	@Autowired
	private SateliteRepository satRepository;
	
	@Autowired
	private ApiConsumeService apiConsumeService;

	// Traz satélites do BD
	@GetMapping("/satelites")
	public Page<Satelite> listar(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		Page<Satelite> satelite = this.satRepository.findAll(paginacao);
		return satelite;
	}
	
	// Traz satélites de uma API externa
	@GetMapping("/buscar-satelite/{id}")
	public ResponseEntity<SateliteDto> buscarById(@PathVariable int id) {
		try {
			SateliteRequest request = this.apiConsumeService.buscarSateliteById(id);
			return ResponseEntity.ok(request.converterDto());			
		}catch(HttpClientErrorException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Cadastra satélites no BD
	@PostMapping("/cadastrar")
	public ResponseEntity<SateliteDto> cadastrarById(@RequestBody SateliteDto satDto, UriComponentsBuilder uriBuilder){
		Satelite satelite = satDto.converterModel();
		this.satRepository.save(satelite);
		
		URI uri = uriBuilder.path("/cadastrado/{id}").buildAndExpand(satelite.getId()).toUri();
		return ResponseEntity.created(uri).body(satDto);
	}
	
}
