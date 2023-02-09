package com.laudo.protect.service;

import java.util.List;

import com.laudo.protect.model.OrdemEtapa;

public interface IEtapaService {
	
	public List<OrdemEtapa> buscarTudo();
	public OrdemEtapa iniciarEtapa(OrdemEtapa oEtapa);
	public OrdemEtapa atualizarEtapa(OrdemEtapa oEtapa);
}
