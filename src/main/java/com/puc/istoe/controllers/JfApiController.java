package com.puc.istoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.services.JfService;
import com.puc.istoe.services.TurmaService;

@RestController
@RequestMapping("api/julgfatos")
public class JfApiController {

	@Autowired
	private	JfService jfService;
	
	@Autowired
	private	TurmaService turmaService;

//	@PostMapping
//	public ResponseEntity<JfDto> cadastrarJf(@RequestBody JfDto jfDto) {
//
//		final JfEntity jfEntity = new JfEntity();
//		jfEntity.setStatus(jfDto.getStatus());
//		jfEntity.setTamMaxEquipes(jfDto.getTamMaxEquipes());
//		jfEntity.setTempoMaxExibicaoFato(jfDto.getTempoMaxExibicaoFato());
//		
//		final TurmaEntity turmaEntity = turmaService.buscarTurma(jfDto.getIdTurma());
//		
//		if (turmaEntity != null) {
//			jfEntity.setTurmaEntity(turmaEntity);
//		}
//		
//		jfService.salvar(jfEntity);
//		jfDto.setIdJf(jfEntity.getIdJf());
//		
//		return new ResponseEntity<JfDto>(jfDto, HttpStatus.OK);
//	}
}
