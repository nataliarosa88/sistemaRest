package com.transportadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transportadora.model.Endereco;
import com.transportadora.service.EnderecoService;

@RestController
public class EnderecoController {
 
 @Autowired
 EnderecoService enderecoService;
 
 @RequestMapping(value="/endereco/", method = RequestMethod.GET, headers="Accept=application/json")
 public ResponseEntity<List<Endereco>> listAll(){
  List<Endereco> list = enderecoService.listAll();
  
  if(list.size() == 0){
   return new ResponseEntity<List<Endereco>>(HttpStatus.NO_CONTENT);
  }
  
  return new ResponseEntity<List<Endereco>>(list, HttpStatus.OK);
 }
 
 
 @RequestMapping(value="/findById/{id}", method = RequestMethod.GET, headers="Accept=application/json")
 public ResponseEntity<List<Endereco>> findById(@PathVariable("id") int id){
	 Endereco endereco = new Endereco();
	 endereco.setId(id);
	 List<Endereco> list = enderecoService.findById(endereco);
	  if(list.size() == 0){
		   return new ResponseEntity<List<Endereco>>(HttpStatus.NO_CONTENT);
		  } 
		  return new ResponseEntity<List<Endereco>>(list, HttpStatus.OK);
 }
 
 
 @RequestMapping(value="/add/", method = RequestMethod.POST, headers="Accept=application/json")
 public ResponseEntity<Void> add(@RequestBody Endereco endereco){
  enderecoService.add(endereco);
  
  HttpHeaders headers = new HttpHeaders();
  return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
 }
 
 @RequestMapping(value="/update/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
 public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Endereco endereco){
  endereco.setId(id);
  enderecoService.update(endereco);
  
  HttpHeaders headers = new HttpHeaders();
  return new ResponseEntity<Void>(headers, HttpStatus.OK);
 }
 
 @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
 public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Endereco endereco){
  endereco.setId(id);
  enderecoService.delete(endereco);
  
  HttpHeaders headers = new HttpHeaders();
  return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
 }
  
}