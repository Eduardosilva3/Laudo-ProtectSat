package com.laudo.protect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laudo.protect.model.OrdemEtapa;
import com.laudo.protect.repository.dao.OrdemEtapaDao;

@Service
public class OrdemEtapaService implements IEtapaService{
	
	@Autowired
	private OrdemEtapaDao dao;

	@Override
	public List<OrdemEtapa> buscarTudo() {
		// TODO Auto-generated method stub
		return (List<OrdemEtapa>) dao.findAll();
	}

	@Override
	public OrdemEtapa iniciarEtapa(OrdemEtapa oEtapa) {
		// TODO Auto-generated method stub
		return dao.save(oEtapa);
	}

	@Override
	public OrdemEtapa atualizarEtapa(OrdemEtapa oEtapa) {
		// TODO Auto-generated method stub
		return dao.save(oEtapa);
	}
}
