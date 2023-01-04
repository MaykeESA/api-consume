package br.com.teste.model.bd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "satelites")
public class Satelite {
	@Id
	public Long id;
	public double latitude;
	public double longitude;
	public double altitude;
	public double velocity;
	public String units;
	
	public Satelite() {
		
	}
	
	public Satelite(Long id, double lat, double lon, double alt, double vel, String units) {
		this.id = id;
		this.latitude = lat;
		this.longitude = lon;
		this.altitude = alt;
		this.velocity = vel;
		this.units = units;
	}
}
