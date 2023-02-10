package com.laudo.protect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.laudo.protect.service.OrdemEtapaService;



import com.laudo.protect.model.*;

@RestController
public class EtapaController {
	
	@Autowired
	private OrdemEtapaService service;
	
	
	@GetMapping("/etapa")
	public List<OrdemEtapa> buscarTodas(){
		
		return service.buscarTudo();
	}
	
	
	@PutMapping("/etapa")
	public ResponseEntity<OrdemEtapa> atualizarEtapa(@RequestBody OrdemEtapa ordemEtapa) {
		
		OrdemEtapa res = service.atualizarEtapa(ordemEtapa);
		
		if(res!=null) {
			return ResponseEntity.ok(res);
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
}
