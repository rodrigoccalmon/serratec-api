package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1")
public class HelloWorldController {
	
	@GetMapping ("/maiuscula")
	public String gerarMaiuscula(@RequestParam String valor) {
		return valor.toUpperCase();
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/ola")
	public String ola() {
		return "ola";
	}

}