package br.com.teste;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.teste.service.ConnectionService;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConnectionService cs = new ConnectionService("http://ergast.com/api/f1/2022/drivers.json");
		System.out.println(cs.getServerResponse().headers());
	}
}
