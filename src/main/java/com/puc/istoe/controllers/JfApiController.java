package com.puc.istoe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.dtos.JfDto;
import com.puc.istoe.entities.JfEntity;
import com.puc.istoe.entities.TurmaEntity;
import com.puc.istoe.services.JfService;
import com.puc.istoe.services.TurmaService;

@RestController
@RequestMapping("api/jfs")
public class JfApiController {
	
	@Autowired
	private JfService jfService;
	
	@Autowired
	private TurmaService turmaService;
	
	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping
	public ResponseEntity<JfDto> cadastrarJf(@RequestBody JfDto jfDto) {

		final JfEntity jfEntity = new JfEntity();
		jfEntity.setStatus(jfDto.getStatus());
		jfEntity.setTamMaxEquipes(jfDto.getTamMaxEquipes());
		jfEntity.setTempoMaxExibicaoFato(jfDto.getTempoMaxExibicaoFato());

		final TurmaEntity turmaEntity = turmaService.buscarTurma(new Long(jfDto.getIdTurma()));

		if (turmaEntity != null) {
			jfEntity.setTurmaEntity(turmaEntity);
		}

		jfService.salvar(jfEntity);
		jfDto.setIdJf(jfEntity.getIdJf());

		return new ResponseEntity<JfDto>(jfDto, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping
	public ResponseEntity<List<JfDto>> buscarJfs(@RequestParam String idTurma) {

		List<JfDto> jfsResonse = new ArrayList<JfDto>();
		JfDto jfDto;
		final List<JfEntity> jfs = jfService.buscarJfPorTurma(new Long(idTurma));
		
		
		if (jfs != null) {
			
			for (JfEntity jf : jfs) {
				jfDto = new JfDto();
				jfDto.setIdJf(jf.getIdJf());
				jfDto.setStatus(jf.getStatus());
				jfDto.setTamMaxEquipes(jf.getTamMaxEquipes());
				jfDto.setTempoMaxExibicaoFato(jf.getTempoMaxExibicaoFato());
				jfsResonse.add(jfDto);
			}
			
			return new ResponseEntity<List<JfDto>>(jfsResonse, HttpStatus.OK);
		}

		return new ResponseEntity<List<JfDto>>(HttpStatus.BAD_REQUEST);
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/{idJf}")
	@PatchMapping
	public ResponseEntity<JfDto> alterarStatus(@PathVariable("idJf") String idJf, @RequestBody JfDto jfDtoRequest) {

		final JfEntity jfEntity = jfService.buscarJf(new Long(idJf));
		
		if (jfEntity != null) {
			jfEntity.setStatus(jfDtoRequest.getStatus());
			jfService.salvar(jfEntity);
			
			final JfDto jfDto = new JfDto();
			jfDto.setIdJf(jfEntity.getIdJf());
			jfDto.setStatus(jfEntity.getStatus());
			jfDto.setTamMaxEquipes(jfEntity.getTamMaxEquipes());
			jfDto.setTempoMaxExibicaoFato(jfEntity.getTempoMaxExibicaoFato());
			
			return new ResponseEntity<JfDto>(jfDto, HttpStatus.OK);
		}

		return new ResponseEntity<JfDto>(HttpStatus.BAD_REQUEST);
	}
}
