package br.com.alura.screenmatch.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.repository.SerieRepository;

@RestController
public class SerieController {
	
	@Autowired
	SerieRepository repositorio;
	
	@GetMapping("/series")
	public List<SerieDTO> obterSeires(){
		return repositorio.findAll().stream()
				.map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
				.collect(Collectors.toList());
		
	}

}
