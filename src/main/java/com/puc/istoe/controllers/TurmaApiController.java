package com.puc.istoe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.dtos.AlunoDto;
import com.puc.istoe.dtos.TurmaDto;
import com.puc.istoe.entities.AlunoEntity;
import com.puc.istoe.entities.ProfessorEntity;
import com.puc.istoe.entities.TurmaEntity;
import com.puc.istoe.services.AlunoService;
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

	@CrossOrigin(origins = "http://localhost:8081")
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

	@CrossOrigin(origins = "http://localhost:8081")
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

	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = "http://localhost:8081")
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
		if (turmaEntity.getProfessorEntity() != null) {
			turmaDto.setIdProfessor(turmaEntity.getProfessorEntity().getIdProfessor());			
		}
		turmaDto.setUnidade(turmaEntity.getUnidade());
		turmaDto.setAlunos(turmaEntity.getAlunos());
		turmaDto.setIdTurma(turmaEntity.getIdTurma());

		return turmaDto;
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping
	public ResponseEntity<List<TurmaDto>> buscarTurmaProfessor(@RequestParam String idProfessor) {

		final ProfessorEntity professorEntity = professorService.buscarProfessorIdProfessor(new Long(idProfessor));
	
		if (professorEntity != null) {
			final List<TurmaEntity> turmasEntity = turmaService.buscarTurmasProfessor(professorEntity);
			final List<TurmaDto> turmasDto = new ArrayList<TurmaDto>();
			
			for (TurmaEntity turmaEntity : turmasEntity) {
				turmasDto.add(transformarTurmaParaDto(turmaEntity));
			}
			
			return new ResponseEntity<List<TurmaDto>>(turmasDto, HttpStatus.OK);
			}

		return new ResponseEntity<List<TurmaDto>>(HttpStatus.BAD_REQUEST);
	}
}
