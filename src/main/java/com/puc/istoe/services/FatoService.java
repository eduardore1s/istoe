package com.puc.istoe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.istoe.entities.FatoEntity;
import com.puc.istoe.repositories.FatoRepository;

@Service
public class FatoService {
	
	@Autowired
	private FatoRepository fatoRepository;
	
	public void salvar(FatoEntity fatoEntity) {
		fatoRepository.save(fatoEntity);
	}
}
