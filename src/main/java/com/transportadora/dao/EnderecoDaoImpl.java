package com.transportadora.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.transportadora.model.Endereco;
import com.transportadora.service.EnderecoService;

@Repository
public class EnderecoDaoImpl implements EnderecoDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List listAll() {
		List list = new ArrayList();

		String sql = "SELECT id, cep, endereco, bairro, cidade, estado, pais FROM enderecos";

		list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new EnderecoMapper());

		return list;
	}
	
	public List findById(Endereco endereco) {
		List list = new ArrayList();
		//Endereco id = endereco.getId();
		String sql = "SELECT id, cep, endereco, bairro, cidade, estado, pais FROM enderecos WHERE id =:id";
		
		list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(endereco), new EnderecoMapper());
		
		return list;

	}

	private SqlParameterSource getSqlParameterByModel(Endereco endereco) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (endereco != null) {
		
			parameterSource.addValue("id", endereco.getId());
			parameterSource.addValue("cep", endereco.getCep());
			parameterSource.addValue("endereco", endereco.getEndereco());
			parameterSource.addValue("bairro", endereco.getBairro());
			parameterSource.addValue("cidade", endereco.getCidade());
			parameterSource.addValue("estado", endereco.getEstado());
			parameterSource.addValue("pais", endereco.getPais());
		}
		
		return parameterSource;
	}

	private static final class EnderecoMapper implements RowMapper<Endereco> {

		public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {
			Endereco endereco = new Endereco();
			endereco.setId(rs.getInt("id"));
			endereco.setCep(rs.getString("cep"));
			endereco.setEndereco(rs.getString("endereco"));
			endereco.setBairro(rs.getString("bairro"));
			endereco.setCidade(rs.getString("cidade"));
			endereco.setEstado(rs.getString("estado"));
			endereco.setPais(rs.getString("pais"));

			return endereco;
		}

	}

	public void add(Endereco endereco) {
		String sql = "INSERT INTO enderecos(cep, endereco, bairro, cidade, estado, pais) VALUES(:cep, :endereco, :bairro, :cidade, :estado, :pais)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(endereco));
	}

	public void update(Endereco endereco) {
		String sql = "UPDATE enderecos SET cep=:cep, endereco=:endereco, bairro=:bairro, cidade=:cidade, estado=:estado, pais=:pais WHERE id =:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(endereco));
	}

	public void delete(Endereco endereco) {
		String sql = "DELETE FROM enderecos WHERE id=:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(endereco));
	}



}
