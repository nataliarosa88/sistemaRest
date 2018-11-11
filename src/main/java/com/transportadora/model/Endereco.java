package com.transportadora.model;

public class Endereco {
	private Integer id;
	 private String cep;
	 private String endereco;
	 private String bairro;
	 private String cidade;
	 private String estado;
	 private String pais;
	 
	 public Endereco() {
	  super();
	 }
	 
	 public Endereco(Integer id) {
	  super();
	  this.id = id;
	 }

	 public Integer getId() {
	  return id;
	 }
	 public void setId(Integer id) {
	  this.id = id;
	 }

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
