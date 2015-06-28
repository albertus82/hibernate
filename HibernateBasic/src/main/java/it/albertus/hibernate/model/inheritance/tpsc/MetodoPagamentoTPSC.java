package it.albertus.hibernate.model.inheritance.tpsc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TPSC_METODI_PAGAMENTO")
public abstract class MetodoPagamentoTPSC {

	@Id
	@SequenceGenerator(name = "seq_metodo_pagamento", sequenceName = "SEQ_METODO_PAGAMENTO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_metodo_pagamento")
	@Column(name = "ID_METODO_PAGAMENTO", nullable = false)
	protected Long id;

	@Column(nullable = false)
	protected String titolare;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolare() {
		return titolare;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}

}
