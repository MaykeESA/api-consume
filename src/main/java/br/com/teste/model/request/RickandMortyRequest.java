package br.com.teste.model.request;

import lombok.Data;

@Data
public class RickandMortyRequest {

	private Long id;
	private String name;
	private Origin origin;
	private String image;
}
