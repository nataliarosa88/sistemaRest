package com.transportadora.service;

import java.util.List;

import com.transportadora.model.Endereco;

public interface EnderecoService {
	
	public List listAll();
	 
	public void add(Endereco endereco);
	 
	public void update(Endereco endereco);
	 
	public void delete(Endereco endereco);
	 
	public List findById(Endereco endereco);
}
