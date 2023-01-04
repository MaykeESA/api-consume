package br.com.teste.model.request;

import br.com.teste.model.dto.SateliteDto;
import lombok.Data;

@Data
public class SateliteRequest {
    public String name;
    public Long id;
    public double latitude;
    public double longitude;
    public double altitude;
    public double velocity;
    public String visibility;
    public double footprint;
    public int timestamp;
    public double daynum;
    public double solar_lat;
    public double solar_lon;
    public String units;
    
    public SateliteDto converterDto() {
    	return new SateliteDto(this.id, this.latitude, this.longitude, this.altitude, this.velocity, this.units);
    }
}

