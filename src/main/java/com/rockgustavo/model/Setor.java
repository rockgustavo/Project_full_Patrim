package com.rockgustavo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "setor")
public class Setor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer setor_id;

	private boolean situacao;
	private String nome;
	private String area;
	private Date date_create;
	private Date date_update;

	@JsonIgnore
	@OneToMany(mappedBy = "setor")
	private List<Usuario> usuarios = new ArrayList<>();

	public Setor() {

	}

	public Setor(Integer setor_id, boolean situacao, String nome, String area, Date date_create, Date date_update) {
		this.setor_id = setor_id;
		this.situacao = situacao;
		this.nome = nome;
		this.area = area;
		this.date_create = date_create;
		this.date_update = date_update;
	}

	public Integer getSetor_id() {
		return setor_id;
	}

	public void setSetor_id(Integer setor_id) {
		this.setor_id = setor_id;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getDate_create() {
		return date_create;
	}

	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}

	public Date getDate_update() {
		return date_update;
	}

	public void setDate_update(Date date_update) {
		this.date_update = date_update;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, date_create, date_update, nome, setor_id, situacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		return Objects.equals(area, other.area) && Objects.equals(date_create, other.date_create)
				&& Objects.equals(date_update, other.date_update) && Objects.equals(nome, other.nome)
				&& Objects.equals(setor_id, other.setor_id) && situacao == other.situacao;
	}

}
