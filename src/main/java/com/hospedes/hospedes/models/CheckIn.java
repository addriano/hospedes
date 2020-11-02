package com.hospedes.hospedes.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TB_CHECKIN")
public class CheckIn {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "hospedeId", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Hospede hospede;

	private Date dataEntrada;
	
	private Date dataSaida;
	
	private boolean veiculo;
	
	@Transient
	private long qtddias;
	
	@Transient
	private Double totalDiaria;
	
	@Transient
	private Double totalDiarias;
	
	public Double getTotalDiarias() {
		return totalDiarias;
	}

	public void setTotalDiarias(Double totalDiarias) {
		this.totalDiarias = totalDiarias;
	}

	public Double getTotalDiaria() {
		return totalDiaria;
	}

	public void setTotalDiaria(Double totalDiaria) {
		this.totalDiaria = totalDiaria;
	}

	public long getQtddias() {
		return qtddias;
	}

	public void setQtddias(long qtddias) {
		this.qtddias = qtddias;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public boolean isVeiculo() {
		return veiculo;
	}

	public void setVeiculo(boolean veiculo) {
		this.veiculo = veiculo;
	}

	
}
