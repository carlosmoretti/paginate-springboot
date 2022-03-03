package com.moretti.paginate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "USER")
@Data
public class User {
	
	@Id
	@Column(name = "USER_CD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USER_TX_NOME")
	@NotNull(message = "O nome do usuário é obrigatório")
	private String nome;
	
	@Column(name = "USER_TX_SOBRENOME")
	private String sobrenome;
}
