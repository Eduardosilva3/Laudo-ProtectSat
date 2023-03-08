package com.laudo.protect.service_test;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.laudo.protect.model.Ordem;
import com.laudo.protect.model.OrdemEtapa;
import com.laudo.protect.repository.dao.OrdemEtapaDao;
import com.laudo.protect.service.OrdemEtapaService;

@ExtendWith(MockitoExtension.class)
public class OrdemEtapaServiceTest {
	
	@Mock
	private OrdemEtapaDao dao;
	
	@InjectMocks
	private OrdemEtapaService service;
	
	
	
	private static List<OrdemEtapa> ordem;
	private static OrdemEtapa ordEtapa;
	
	
	@BeforeAll
	public static void iniciarLista() {
		
		
		Ordem ord = new Ordem(1, 907850123, "Problema de Teste", "99.999.999-99", "Cliente de Teste", null);
		ordEtapa = new OrdemEtapa(1, true, LocalDate.now(), true, LocalDate.now(), ord.getDescricaoProblema(), false, null, null, false, null, ord);
		ord.setOrdemEtapa(ordEtapa);
		
		Ordem ord1 = new Ordem(1, 907850123, "Problema de Teste02", "88.888.888-88", "Cliente de Teste02", null);
		OrdemEtapa ordEtapa1 = new OrdemEtapa(2, true, LocalDate.now(), true, LocalDate.now(), ord1.getDescricaoProblema(), true, LocalDate.of(2023, 3, 15), "Laudo temporario test", true, "link", ord1);
		ord1.setOrdemEtapa(ordEtapa1);
		
		ordem = Arrays.asList(ordEtapa, ordEtapa1);
		
	}
	
	@Test
	public void testeSalvar() {
		
		when(dao.save(ordEtapa)).thenReturn(ordEtapa);
		
		OrdemEtapa res = service.iniciarEtapa(ordEtapa);
		
		Assertions.assertEquals(ordEtapa, res);
		
	}
	
	@Test
	public void testeAtualizar() {
		
		when(dao.save(ordEtapa)).thenReturn(ordEtapa);
		
		OrdemEtapa res = service.atualizarEtapa(ordEtapa);
		
		Assertions.assertEquals(ordEtapa, res);
		
	}
	
	@Test
	public void buscarTodos() {
		when(dao.findAll()).thenReturn(ordem);
		
		List<OrdemEtapa> res = service.buscarTudo();
		
		Assertions.assertEquals(ordem, res);
	}
	
	
}
