package com.puc.istoe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class Controller {

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> test() {

		List<Aluno> alunos = new ArrayList<>();

		alunos.add(new Aluno("Eduardo", 22));
		alunos.add(new Aluno("João", 22));
		alunos.add(new Aluno("Rafael", 24));
		
		return new ResponseEntity<List<Aluno>>(alunos,HttpStatus.OK);
	}
}
