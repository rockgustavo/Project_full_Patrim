package com.rockgustavo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patrimonio")
public class Patrimonio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patrim_id;

	private boolean situacao;
	private Integer registro_interno;
	private String foto_url_item;
	private String descricao;
	private Double valor;
	private String dados_comp;
	private String dados_baixa;
	private Date date_baixa;
	private Date date_create;
	private Date date_update;

	@ManyToOne
	@JoinColumn(name = "user_id_fk")
	private Usuario usuario;

	public Patrimonio() {

	}

	public Patrimonio(Integer patrim_id, boolean situacao, Integer registro_interno, String foto_url_item,
			String descricao, Double valor, String dados_comp, String dados_baixa, Date date_baixa, Date date_create,
			Date date_update, Usuario usuario) {
		this.patrim_id = patrim_id;
		this.situacao = situacao;
		this.registro_interno = registro_interno;
		this.foto_url_item = foto_url_item;
		this.descricao = descricao;
		this.valor = valor;
		this.dados_comp = dados_comp;
		this.dados_baixa = dados_baixa;
		this.date_baixa = date_baixa;
		this.date_create = date_create;
		this.date_update = date_update;
		this.usuario = usuario;
	}

	public Integer getPatrim_id() {
		return patrim_id;
	}

	public void setPatrim_id(Integer patrim_id) {
		this.patrim_id = patrim_id;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public Integer getRegistro_interno() {
		return registro_interno;
	}

	public void setRegistro_interno(Integer registro_interno) {
		this.registro_interno = registro_interno;
	}

	public String getFoto_url_item() {
		return foto_url_item;
	}

	public void setFoto_url_item(String foto_url_item) {
		this.foto_url_item = foto_url_item;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDados_comp() {
		return dados_comp;
	}

	public void setDados_comp(String dados_comp) {
		this.dados_comp = dados_comp;
	}

	public String getDados_baixa() {
		return dados_baixa;
	}

	public void setDados_baixa(String dados_baixa) {
		this.dados_baixa = dados_baixa;
	}

	public Date getDate_baixa() {
		return date_baixa;
	}

	public void setDate_baixa(Date date_baixa) {
		this.date_baixa = date_baixa;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dados_baixa, dados_comp, date_baixa, date_create, date_update, descricao, foto_url_item,
				patrim_id, registro_interno, situacao, usuario, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patrimonio other = (Patrimonio) obj;
		return Objects.equals(dados_baixa, other.dados_baixa) && Objects.equals(dados_comp, other.dados_comp)
				&& Objects.equals(date_baixa, other.date_baixa) && Objects.equals(date_create, other.date_create)
				&& Objects.equals(date_update, other.date_update) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(foto_url_item, other.foto_url_item) && Objects.equals(patrim_id, other.patrim_id)
				&& Objects.equals(registro_interno, other.registro_interno) && situacao == other.situacao
				&& Objects.equals(usuario, other.usuario) && Objects.equals(valor, other.valor);
	}

}
