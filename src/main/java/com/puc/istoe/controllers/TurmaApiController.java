package com.puc.istoe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.dtos.AlunoDto;
import com.puc.istoe.dtos.JfDto;
import com.puc.istoe.dtos.TurmaDto;
import com.puc.istoe.entities.AlunoEntity;
import com.puc.istoe.entities.JfEntity;
import com.puc.istoe.entities.ProfessorEntity;
import com.puc.istoe.entities.TurmaEntity;
import com.puc.istoe.services.AlunoService;
import com.puc.istoe.services.JfService;
import com.puc.istoe.services.ProfessorService;
import com.puc.istoe.services.TurmaService;

@RestController
@RequestMapping("api/turmas")
public class TurmaApiController {

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private JfService jfService;

	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity<TurmaDto> cadastrarturma(@RequestBody TurmaDto turmaDto) {

		final TurmaEntity turmaEntity = new TurmaEntity();
		turmaEntity.setCurso(turmaDto.getCurso());
		turmaEntity.setDisciplina(turmaDto.getCurso());
		turmaEntity.setUnidade(turmaDto.getUnidade());

		final ProfessorEntity professorEntity = professorService.buscarProfessorIdProfessor(turmaDto.getIdProfessor());
		if (professorEntity != null) {
			turmaEntity.setProfessorEntity(professorEntity);
		}
		turmaService.salvar(turmaEntity);
		turmaDto.setIdTurma(turmaEntity.getIdTurma());
		return new ResponseEntity<TurmaDto>(turmaDto, HttpStatus.OK);
	}

	@RequestMapping("/{idTurma}")
	@GetMapping
	public ResponseEntity<TurmaDto> buscarturma(@PathVariable("idTurma") Long idTurma) {

		final TurmaEntity turmaEntity = turmaService.buscarTurma(idTurma);

		if (turmaEntity != null) {
			final TurmaDto turmaDto = transformarTurmaParaDto(turmaEntity);

			return new ResponseEntity<TurmaDto>(turmaDto, HttpStatus.OK);
		}

		return new ResponseEntity<TurmaDto>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping("/{idTurma}/alunos")
	@PostMapping
	public ResponseEntity<TurmaDto> incluirAluno(@PathVariable("idTurma") String idTurma,
			@RequestBody AlunoDto alunoDto) {

		final TurmaEntity turmaEntity = turmaService.buscarTurma(new Long(idTurma));

		if (turmaEntity != null) {

			final AlunoEntity alunoEntity = alunoService.buscarAlunoIdAluno(alunoDto.getIdAluno());

			if (alunoEntity != null) {
				turmaEntity.getAlunos().add(alunoEntity);
				turmaService.salvar(turmaEntity);
				final TurmaDto turmaDto = transformarTurmaParaDto(turmaEntity);

				return new ResponseEntity<TurmaDto>(turmaDto, HttpStatus.OK);
			}
		}

		return new ResponseEntity<TurmaDto>(HttpStatus.BAD_REQUEST);
	}

	public TurmaDto transformarTurmaParaDto(TurmaEntity turmaEntity) {
		final TurmaDto turmaDto = new TurmaDto();
		turmaDto.setCurso(turmaEntity.getCurso());
		turmaDto.setDisciplina(turmaEntity.getDisciplina());
		turmaDto.setIdProfessor(turmaEntity.getProfessorEntity().getIdProfessor());
		turmaDto.setUnidade(turmaEntity.getUnidade());
		turmaDto.setAlunos(turmaEntity.getAlunos());
		turmaDto.setIdTurma(turmaEntity.getIdTurma());

		return turmaDto;
	}

	@PostMapping("/{idTurma}/jfs")
	public ResponseEntity<JfDto> cadastrarJf(@PathVariable("idTurma") String idTurma, @RequestBody JfDto jfDto) {

		final JfEntity jfEntity = new JfEntity();
		jfEntity.setStatus(jfDto.getStatus());
		jfEntity.setTamMaxEquipes(jfDto.getTamMaxEquipes());
		jfEntity.setTempoMaxExibicaoFato(jfDto.getTempoMaxExibicaoFato());

		final TurmaEntity turmaEntity = turmaService.buscarTurma(new Long(idTurma));

		if (turmaEntity != null) {
			jfEntity.setTurmaEntity(turmaEntity);
		}

		jfService.salvar(jfEntity);
		jfDto.setIdJf(jfEntity.getIdJf());

		return new ResponseEntity<JfDto>(jfDto, HttpStatus.OK);
	}

	@RequestMapping("/{idTurma}/jfs/{idJf}")
	@PatchMapping
	public ResponseEntity<JfDto> alterarStatus(@PathVariable("idTurma") String idTurma,
			@PathVariable("idJf") String idJf, @RequestBody JfDto jfDtoRequest) {

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
	
	@GetMapping("/{idTurma}/jfs")
	public ResponseEntity<List<JfDto>> buscarJfs(@PathVariable("idTurma") String idTurma) {

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
}
