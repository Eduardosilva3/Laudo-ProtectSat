package com.laudo.protect.controllerTest;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.laudo.protect.controller.OrdemController;
import com.laudo.protect.model.Ordem;
import com.laudo.protect.model.OrdemEtapa;
import com.laudo.protect.service.OrdemService;

@ExtendWith(MockitoExtension.class)
public class OrdemControllerTest {
	
	
	@Mock
	private OrdemService service;
	
	@InjectMocks
	private OrdemController controller;
	
	private static List<Ordem> ordem;
	private static Ordem ord;
	
	@BeforeAll
	public static void iniciarLista() {
		
		
		ord = new Ordem(1, 907850123, "Problema de Teste", "99.999.999-99", "Cliente de Teste", null);
		OrdemEtapa ordEtapa = new OrdemEtapa(1, true, LocalDate.now(), true, LocalDate.now(), ord.getDescricaoProblema(), false, null, null, false, null, ord);
		ord.setOrdemEtapa(ordEtapa);
		
		Ordem ord1 = new Ordem(1, 907850123, "Problema de Teste02", "88.888.888-88", "Cliente de Teste02", null);
		OrdemEtapa ordEtapa1 = new OrdemEtapa(2, true, LocalDate.now(), true, LocalDate.now(), ord1.getDescricaoProblema(), true, LocalDate.of(2023, 3, 15), "Laudo temporario test", true, "link", ord1);
		ord1.setOrdemEtapa(ordEtapa1);
		
		ordem = Arrays.asList(ord, ord1);
		
	}
	
	
	@Test
	public void buscarTodosTest() {
		
		
		
		when(service.buscarTodas()).thenReturn(ordem);
		
		List<Ordem> res = controller.buscarTodos();
		
		Assertions.assertEquals(ordem, res);
		
		
		
		
	}
	
	@Test
	public void buscarPorCnpj() {
		
		List<Ordem> ord = ordem.stream().filter(or -> or.getCnpjCliente().equals("88.888.888-88")).collect(Collectors.toList());
		
		when(service.buscarPorCnpj("88.888.888-88")).thenReturn(ord);
		
		ResponseEntity<List<Ordem>> res = controller.buscarCnpj("88.888.888-88");
		
		Assertions.assertEquals(ord,res.getBody());
		
		
		
		
	}
	
	
	@Test
	public void buscarPorCnpjErro() {
		
		
		
		when(service.buscarPorCnpj("88.888.888-88")).thenReturn(null);
		
		ResponseEntity<List<Ordem>> res = controller.buscarCnpj("88.888.888-88");
		
		Assertions.assertEquals(404,res.getStatusCodeValue());
		
		
		
		
	}
	
	@Test
	public void buscarPorId() {
		
		
		
		when(service.buscarPorId(1)).thenReturn(ord);
		
		ResponseEntity<Ordem> res = controller.buscarPeloId(1);
		
		Assertions.assertEquals(ord,res.getBody());
		
		ResponseEntity<Ordem> resError = controller.buscarPeloId(2);
		
		Assertions.assertEquals(404, resError.getStatusCodeValue());
		
		
		
		
	}
	
	@Test
	public void IniciarNovaOrdem() {
		
		Ordem ordNova = new Ordem(1, 907850123, "Problema de Teste", "99.999.999-99", "Cliente de Teste", null);
		OrdemEtapa ordEtapa = new OrdemEtapa(1, true, LocalDate.now(), true, LocalDate.now(), ord.getDescricaoProblema(), false, null, null, false, null, ord);
		ordNova.setOrdemEtapa(ordEtapa);
		
		
		when(service.iniciarOrdem(ordNova)).thenReturn(ord);
		
		ResponseEntity<Ordem> res = controller.iniciarNovaOrdem(ordNova);
		
		Assertions.assertEquals(ord,res.getBody());
		
		ResponseEntity<Ordem> resError = controller.iniciarNovaOrdem(null);
		
		ResponseEntity<Ordem> resError404 = controller.iniciarNovaOrdem(ord);
		
		Assertions.assertEquals(400, resError.getStatusCodeValue());
		Assertions.assertEquals(404, resError404.getStatusCodeValue());
		
		
		
		
	}
	

}
