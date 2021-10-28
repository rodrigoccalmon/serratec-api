package org.serratec.backend.exercicio002veiculo.controller;
import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.exercicio002veiculo.domain.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	private static List<Veiculo> lista = new ArrayList<Veiculo>();
	
	static {
		lista.add(new Veiculo(1, "Honda", "Fit"));
		lista.add(new Veiculo(2, "Jeep", "Renegade"));
		lista.add(new Veiculo(3, "Nissan", "Kicks"));
		lista.add(new Veiculo(4, "Ford", "Fiesta"));		
	}
	
	@GetMapping
	public List<Veiculo> listarVeiculo() {
		return lista;
	}
	
	@GetMapping("{marca}")
	public Veiculo buscarVeiculo(@PathVariable String marca) {
		for (Veiculo veiculo : lista ) {
			if(veiculo.getMarca().equals(marca)) {
				return veiculo;
			}
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		lista.add(veiculo);
		return veiculo;
	}
	
	@DeleteMapping ("{marca}")
	public void delete(@PathVariable String marca ) {
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getMarca().equals(marca)) {
				lista.remove(i);
			}
		}
	}
	
}
