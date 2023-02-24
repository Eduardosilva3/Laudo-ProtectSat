package com.laudo.protect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laudo.protect.model.Ordem;
import com.laudo.protect.service.OrdemService;

@RestController
public class OrdemController {
	
	@Autowired
	private OrdemService service;
	
	@RequestMapping(value = "/ordem", method = RequestMethod.GET)
	public List<Ordem> buscarTodos(){
		System.out.println("controller");
		return service.buscarTodas();
	}
	
	@RequestMapping(value = "/ordem/cnpj", method = RequestMethod.GET)
	public ResponseEntity<List<Ordem>> buscarCnpj(@RequestParam("cnpj") String cnpj){
		
		List<Ordem> retorno = service.buscarPorCnpj(cnpj);
		
		if(retorno!=null) {
			return ResponseEntity.ok(retorno);
		}else {
			return ResponseEntity.notFound().build();
		}
	};
	
	
	@RequestMapping(value = "/ordem/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ordem> buscarPeloId(@PathVariable int id){
		
		Ordem res = service.buscarPorId(id);
		
		
		
		if(res!=null) {
			
			return ResponseEntity.ok(res);
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	@RequestMapping(value = "/ordem", method = RequestMethod.POST)
	public ResponseEntity<Ordem> iniciarNovaOrdem(@RequestBody Ordem ordem){
		
		Ordem res = service.iniciarOrdem(ordem);
		
		if(res!=null) {
			return ResponseEntity.ok(res);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
 }
