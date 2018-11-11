package com.transportadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transportadora.dao.EnderecoDao;
import com.transportadora.model.Endereco;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	EnderecoDao enderecoDao;

	@Autowired
	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
	}

	public List listAll() {
		return enderecoDao.listAll();
	}
	
	public List findById(Endereco endereco) {
		return enderecoDao.findById(endereco);
	}

	public void add(Endereco endereco) {
		enderecoDao.add(endereco);
	}

	public void update(Endereco endereco) {
		enderecoDao.update(endereco);
	}

	public void delete(Endereco endereco) {
		enderecoDao.delete(endereco);
	}



}