package com.laudo.protect.service;

import java.util.List;

import com.laudo.protect.model.Ordem;

public interface IOrdemService {

	public List<Ordem> buscarTodas();
	public List<Ordem> buscarPorCnpj(String cnpj);
	public Ordem buscarPorId(int id);
	public Ordem iniciarOrdem(Ordem ordem);
}
