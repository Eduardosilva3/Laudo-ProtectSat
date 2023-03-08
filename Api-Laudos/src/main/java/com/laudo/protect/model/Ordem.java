package com.laudo.protect.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name ="ordem")
public class Ordem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ordem", nullable = false, unique = true)
	private int idOrdem;
	
	@Column(name = "id_equipamento", nullable = false)
	private int idEquipamento;
	
	@Column(name = "descricao_problema", nullable = false, length = 1000)
	private String descricaoProblema;
	
	@Column(name = "cnpj_cliente", nullable = false, length = 30)
	private String cnpjCliente;
	
	@Column(name = "nome_cliente", nullable = false, length = 50)
	private String nomeCliente;
	
	@OneToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "id_etapa")
	private OrdemEtapa ordemEtapa;
	
	

	public Ordem(int idOrdem, int idEquipamento, String descricaoProblema, String cnpjCliente, String nomeCliente,
			OrdemEtapa ordemEtapa) {
		super();
		this.idOrdem = idOrdem;
		this.idEquipamento = idEquipamento;
		this.descricaoProblema = descricaoProblema;
		this.cnpjCliente = cnpjCliente;
		this.nomeCliente = nomeCliente;
		this.ordemEtapa = ordemEtapa;
	}
	
	public Ordem(int idEquipamento, String descricaoProblema, String cnpjCliente, String nomeCliente,
			OrdemEtapa ordemEtapa) {
		
		this.idEquipamento = idEquipamento;
		this.descricaoProblema = descricaoProblema;
		this.cnpjCliente = cnpjCliente;
		this.nomeCliente = nomeCliente;
		this.ordemEtapa = ordemEtapa;
	}
	
	

	public Ordem() {
		super();
	}



	public int getIdOrdem() {
		return idOrdem;
	}

	public void setIdOrdem(int idOrdem) {
		this.idOrdem = idOrdem;
	}

	public int getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public String getCnpjCliente() {
		return cnpjCliente;
	}

	public void setCnpjCliente(String cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public OrdemEtapa getOrdemEtapa() {
		return ordemEtapa;
	}

	public void setOrdemEtapa(OrdemEtapa ordemEtapa) {
		this.ordemEtapa = ordemEtapa;
	}

	
	
	
	
	
}
