package com.puc.istoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.dtos.FatoDto;
import com.puc.istoe.entities.FatoEntity;
import com.puc.istoe.entities.JfEntity;
import com.puc.istoe.services.FatoService;
import com.puc.istoe.services.JfService;

@RestController
@RequestMapping("api/fatos")
public class FatoApiController {
	
	@Autowired
	private FatoService fatoService;
	
	@Autowired
	private JfService jfService;
	
	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping
	public ResponseEntity<FatoDto> cadastrarFatos(@RequestBody FatoDto fatoDto) {

		final FatoEntity fatoEntity = new FatoEntity();
		fatoEntity.setOrdem(fatoDto.getOrdem());
		fatoEntity.setConteudo(fatoDto.getConteudo());
		fatoEntity.setTopicoDisciplina(fatoDto.getTopicoDisciplina());
		fatoEntity.setResposta(fatoDto.getResposta());
		
		final JfEntity jfEntity = jfService.buscarJf(new Long(fatoDto.getIdJf()));
		if (jfEntity != null) {
			fatoEntity.setJf(jfEntity);
			fatoDto.setIdJf(jfEntity.getIdJf());
		}		
		fatoService.salvar(fatoEntity);
		fatoDto.setIdFato(fatoEntity.getIdFato());

		return new ResponseEntity<FatoDto>(fatoDto, HttpStatus.OK);
	}
}
