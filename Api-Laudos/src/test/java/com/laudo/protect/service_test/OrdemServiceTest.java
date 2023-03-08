package com.laudo.protect.service_test;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.laudo.protect.model.Ordem;
import com.laudo.protect.model.OrdemEtapa;
import com.laudo.protect.repository.dao.OrdemDao;

import com.laudo.protect.service.OrdemEtapaService;
import com.laudo.protect.service.OrdemService;

@ExtendWith(MockitoExtension.class)
public class OrdemServiceTest {
		
		
		
	@Mock
	private OrdemDao dao;
	
	@Mock
	private OrdemEtapaService service;
	

	@InjectMocks
	private OrdemService serviceOrdem;
	
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
	public void iniciarOrdem() {
		
		
		Ordem res = new Ordem(1, 907850123, "Problema de Teste", "99.999.999-99", "Cliente de Teste", null);
		
		
		Ordem resEtapa = new Ordem(1, 907850123, "Problema de Teste", "99.999.999-99", "Cliente de Teste", null);
		OrdemEtapa ordemE = new OrdemEtapa(true, LocalDate.now(), true, LocalDate.now(), resEtapa.getDescricaoProblema() , false, false, resEtapa);
		resEtapa.setOrdemEtapa(ordemE);
		
		Ordem save = new Ordem(907850123, "Problema de Teste", "99.999.999-99", "Cliente de Teste", null);
		
		lenient().when(dao.save(save)).thenReturn(res);
		lenient().when(service.iniciarEtapa(Mockito.any(OrdemEtapa.class))).thenReturn(ordemE);
		
		lenient().when(dao.save(Mockito.any(Ordem.class))).thenReturn(resEtapa);
		
		
		
		Ordem retr = serviceOrdem.iniciarOrdem(save);
		
		verify(dao, times(1)).save(save);
		Assertions.assertEquals(resEtapa, retr);
		Assertions.assertEquals(resEtapa.getOrdemEtapa(), retr.getOrdemEtapa());
		
		
	}
	
	@Test
	public void buscarTodas() {
		
		when(dao.findAll()).thenReturn(ordem);
		
		List<Ordem> res = serviceOrdem.buscarTodas();
		
		Assertions.assertEquals(ordem, res);
		
	}
	
	@Test
	public void buscarPorId() {
		
		Optional<Ordem> ord = Optional.ofNullable(new Ordem(1, 907850123, "Problema de Teste", "99.999.999-99", "Cliente de Teste", null));
		
		when(dao.findById(1)).thenReturn(ord);
		
		Optional<Ordem> res = Optional.of(serviceOrdem.buscarPorId(1));
		Ordem resNulo = serviceOrdem.buscarPorId(2);
		
		
		Assertions.assertEquals(ord, res);
		Assertions.assertEquals(null, resNulo);
	}
	
	@Test
	public void buscarPorCnpj() {
		
		List<Ordem> filter = ordem.stream().filter((o)->o.getCnpjCliente().equals("99.999.999-99")).collect(Collectors.toList());
		
		when(dao.findBycnpjCliente("99.999.999-99")).thenReturn(filter);
		
		List<Ordem> res = serviceOrdem.buscarPorCnpj("99.999.999-99");
		List<Ordem> resNulo = serviceOrdem.buscarPorCnpj("2");
		
		
		Assertions.assertEquals(filter, res);
		Assertions.assertTrue(resNulo.isEmpty());
	}
	
	
	
}
