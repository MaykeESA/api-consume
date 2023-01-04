package br.com.teste.model.dto;

import br.com.teste.model.bd.Satelite;

import lombok.Data;

@Data
public class SateliteDto {
	public Long id;
	public double latitude;
	public double longitude;
	public double altitude;
	public double velocity;
	public String units;
	
	public SateliteDto(Long id, double lat, double lon, double alt, double vel, String units) {
		this.id = id;
		this.latitude = lat;
		this.longitude = lon;
		this.altitude = alt;
		this.velocity = vel;
		this.units = units;
	}

	public Satelite converterModel() {
		return new Satelite(this.id, this.altitude, this.altitude, this.altitude, this.altitude, this.units);
	}
}
