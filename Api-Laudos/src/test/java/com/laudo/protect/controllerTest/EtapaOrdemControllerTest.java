package com.laudo.protect.controllerTest;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.laudo.protect.controller.EtapaController;
import com.laudo.protect.model.Ordem;
import com.laudo.protect.model.OrdemEtapa;
import com.laudo.protect.service.OrdemEtapaService;

@ExtendWith(MockitoExtension.class)
public class EtapaOrdemControllerTest {

	@Mock
	private OrdemEtapaService service;
	
	@InjectMocks
	private EtapaController controller;
	
	
	private static List<OrdemEtapa> ordemEtapa;
	private static OrdemEtapa ordEtapa;
	
	@BeforeAll
	public static void startTest() {
		
		
		Ordem ord = new Ordem(1, 907850123, "Problema de Teste", "99.999.999-99", "Cliente de Teste", null);
		ordEtapa = new OrdemEtapa(1, true, LocalDate.now(), true, LocalDate.now(), ord.getDescricaoProblema(), false, null, null, false, null, ord);
		ord.setOrdemEtapa(ordEtapa);
		
		Ordem ord1 = new Ordem(1, 907850123, "Problema de Teste02", "88.888.888-88", "Cliente de Teste02", null);
		OrdemEtapa ordEtapa1 = new OrdemEtapa(2, true, LocalDate.now(), true, LocalDate.now(), ord1.getDescricaoProblema(), true, LocalDate.of(2023, 3, 15), "Laudo temporario test", true, "link", ord1);
		ord1.setOrdemEtapa(ordEtapa1);
		
		ordemEtapa = Arrays.asList(ordEtapa, ordEtapa1);
		
	}
	
	
	@Test
	public void buscarTodas() {
		
		
		
		when(service.buscarTudo()).thenReturn(ordemEtapa);
		
		List<OrdemEtapa> res = controller.buscarTodas();
		
		
		Assertions.assertEquals(ordemEtapa, res);
		
	}
	
	@Test
	public void AtualizarEtapa() {
		Ordem ord = new Ordem(1, 907850123, "Problema de Teste", "99.999.999-99", "Cliente de Teste", null);
		OrdemEtapa ordEtapa1 = new OrdemEtapa(1, true, LocalDate.now(), true, LocalDate.now(), ord.getDescricaoProblema(), true, LocalDate.of(2023, 3, 15), "Laudo temporario test", true, "link", ord);
		when(service.atualizarEtapa(ordEtapa1)).thenReturn(ordEtapa1);
		
		ResponseEntity<OrdemEtapa> res = controller.atualizarEtapa(ordEtapa1);
		ResponseEntity<OrdemEtapa> resError = controller.atualizarEtapa(ordEtapa);
		
		Assertions.assertEquals(ordEtapa1, res.getBody());
		Assertions.assertEquals(404, resError.getStatusCodeValue());
	}
}
