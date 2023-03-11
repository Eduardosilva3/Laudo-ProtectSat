package com.laudo.protect.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laudo.protect.model.Ordem;
import com.laudo.protect.model.OrdemEtapa;
import com.laudo.protect.repository.dao.OrdemDao;

@Service
public class OrdemService implements IOrdemService {

	@Autowired
	private OrdemDao dao;
	
	@Autowired
	private OrdemEtapaService service;
	
	@Override
	public List<Ordem> buscarTodas() {
		// TODO Auto-generated method stub
		return (List<Ordem>) dao.findAll();
	}

	@Override
	public List<Ordem> buscarPorCnpj(String cnpj) {
		// TODO Auto-generated method stub
		
		
		return dao.findBycnpjCliente(cnpj);
	}

	@Override
	public Ordem buscarPorId(int id) {
		// TODO Auto-generated method stub
		
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public Ordem iniciarOrdem(Ordem ordem) {
		// TODO Auto-generated method stub
		Ordem res = dao.save(ordem);
		
		OrdemEtapa ordemE = new OrdemEtapa(true, LocalDate.now(ZoneId.of("America/Sao_Paulo")), true,  LocalDate.now(ZoneId.of("America/Sao_Paulo")), res.getDescricaoProblema() , false, false, res);
		OrdemEtapa resEtapa = service.iniciarEtapa(ordemE);
		res.setOrdemEtapa(resEtapa);
		
		
		
		
		
		
		
			
		
		
		return res = dao.save(res);
	}
	
}
