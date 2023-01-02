package com.rockgustavo.data.vo.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.rockgustavo.model.Patrimonio;
import com.rockgustavo.model.Setor;

public class UsuarioVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer user_id;

	private boolean situacao;
	private String cargo;
	private String nome;
	private String rg;
	private String cpf;
	private String login;
	private String senha;
	private Date date_create;
	private Date date_update;

	private Setor setor;

	private List<Patrimonio> patrims = new ArrayList<>();

	public UsuarioVO() {

	}

	public UsuarioVO(Integer user_id, boolean situacao, String cargo, String nome, String rg, String cpf, String login,
			String senha, Date date_create, Date date_update, Setor setor) {
		this.user_id = user_id;
		this.situacao = situacao;
		this.cargo = cargo;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.date_create = date_create;
		this.date_update = date_update;
		this.setor = setor;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public List<Patrimonio> getPatrims() {
		return patrims;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cargo, cpf, date_create, date_update, login, nome, rg, senha, setor, situacao, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioVO other = (UsuarioVO) obj;
		return Objects.equals(cargo, other.cargo) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(date_create, other.date_create) && Objects.equals(date_update, other.date_update)
				&& Objects.equals(login, other.login) && Objects.equals(nome, other.nome)
				&& Objects.equals(rg, other.rg) && Objects.equals(senha, other.senha)
				&& Objects.equals(setor, other.setor) && situacao == other.situacao
				&& Objects.equals(user_id, other.user_id);
	}

}
