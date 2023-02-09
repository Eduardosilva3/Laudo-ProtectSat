package com.laudo.protect.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="ordem_etapa")
public class OrdemEtapa {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_etapa")
	private int idEtapa;
	
	@Column(name = "etapa_1")
	private boolean etapa_1;
	
	@Column(name = "date_1")
	private LocalDate date_1;
	
	
	
	@Column(name = "etapa_2")
	private boolean etapa_2;
	
	@Column(name = "date_2")
	private LocalDate date_2;
	
	@Column(name = "descricao_2", length = 1000)
	private String descricaoProblema;
	
	
	
	@Column(name = "etapa_3")
	private boolean etapa_3;

	@Column(name = "date_3")
	private LocalDate date_3;
	@Column(name = "laudo_temporario", length = 1000)
	private String laudoTemporario;
	
	@Column(name = "etapa_4")
	private boolean etapa_4;
	@Column(name = "laudo_final", length = 100)
	private String laudoFinal;
	
	
	@OneToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "id_ordem")
	@JsonIgnore
	private Ordem ordem;

	
	
	public int getIdEtapa() {
		return idEtapa;
	}

	public void setIdEtapa(int idEtapa) {
		this.idEtapa = idEtapa;
	}

	public boolean isEtapa_1() {
		return etapa_1;
	}

	public void setEtapa_1(boolean etapa_1) {
		this.etapa_1 = etapa_1;
	}

	public LocalDate getDate_1() {
		return date_1;
	}

	public void setDate_1(LocalDate date_1) {
		this.date_1 = date_1;
	}

	public boolean isEtapa_2() {
		return etapa_2;
	}

	public void setEtapa_2(boolean etapa_2) {
		this.etapa_2 = etapa_2;
	}

	public LocalDate getDate_2() {
		return date_2;
	}

	public void setDate_2(LocalDate date_2) {
		this.date_2 = date_2;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public boolean isEtapa_3() {
		return etapa_3;
	}

	public void setEtapa_3(boolean etapa_3) {
		this.etapa_3 = etapa_3;
	}

	public LocalDate getDate_3() {
		return date_3;
	}

	public void setDate_3(LocalDate date_3) {
		this.date_3 = date_3;
	}

	public String getLaudoTemporario() {
		return laudoTemporario;
	}

	public void setLaudoTemporario(String laudoTemporario) {
		this.laudoTemporario = laudoTemporario;
	}

	public boolean isEtapa_4() {
		return etapa_4;
	}

	public void setEtapa_4(boolean etapa_4) {
		this.etapa_4 = etapa_4;
	}

	public String getLaudoFinal() {
		return laudoFinal;
	}

	public void setLaudoFinal(String laudoFinal) {
		this.laudoFinal = laudoFinal;
	}

	public Ordem getOrdem() {
		return ordem;
	}

	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}

	public OrdemEtapa(boolean etapa_1, LocalDate date_1, boolean etapa_2, LocalDate date_2, String descricaoProblema,
			boolean etapa_3, boolean etapa_4, Ordem ordem) {
		super();
		this.etapa_1 = etapa_1;
		this.date_1 = date_1;
		this.etapa_2 = etapa_2;
		this.date_2 = date_2;
		this.descricaoProblema = descricaoProblema;
		this.etapa_3 = etapa_3;
		this.etapa_4 = etapa_4;
		this.ordem = ordem;
	}
	
	
	
	public OrdemEtapa(int idEtapa, boolean etapa_1, LocalDate date_1, boolean etapa_2, LocalDate date_2,
			String descricaoProblema, boolean etapa_3, LocalDate date_3, String laudoTemporario, boolean etapa_4,
			String laudoFinal, Ordem ordem) {
		super();
		this.idEtapa = idEtapa;
		this.etapa_1 = etapa_1;
		this.date_1 = date_1;
		this.etapa_2 = etapa_2;
		this.date_2 = date_2;
		this.descricaoProblema = descricaoProblema;
		this.etapa_3 = etapa_3;
		this.date_3 = date_3;
		this.laudoTemporario = laudoTemporario;
		this.etapa_4 = etapa_4;
		this.laudoFinal = laudoFinal;
		this.ordem = ordem;
	}

	public OrdemEtapa() {
		// TODO Auto-generated constructor stub
	}
	
}
