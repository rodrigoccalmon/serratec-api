package org.serratec.backend.service;

import java.io.IOException;
import java.util.Optional;

import org.serratec.backend.domain.Foto;
import org.serratec.backend.domain.Funcionario;
import org.serratec.backend.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoService {

	@Autowired
	private FotoRepository fotoRepository;

	public Foto inserir(Funcionario funcionario, MultipartFile file) throws IOException {
		Foto foto = new Foto();
		foto.setNome(funcionario.getNome());
		foto.setTipo(file.getContentType());
		foto.setDados(file.getBytes());
		foto.setFuncionario(funcionario);
		return fotoRepository.save(foto);
	}

	public Foto buscarFoto(Long id) {
		Optional<Foto> foto = fotoRepository.findById(id);
		if (!foto.isPresent()) {
			return null;
		}
		return foto.get();
	}
	
	
}
