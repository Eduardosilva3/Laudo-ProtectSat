package com.laudo.protect.repository.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.laudo.protect.model.Ordem;


public interface OrdemDao extends CrudRepository<Ordem, Integer>{
	
	public List<Ordem> findBycnpjCliente(String cnpj);
}
