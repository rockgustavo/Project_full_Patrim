package com.rockgustavo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rockgustavo.data.vo.v1.UsuarioVO;
import com.rockgustavo.services.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioVO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioVO findById(@PathVariable(value = "id") Integer id) {
		return service.findById(id);
	}
	
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioVO findByAuth(@RequestBody UsuarioVO userVo) {
		return service.findByAuth(userVo);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioVO create(@RequestBody UsuarioVO userVo) {
		return service.create(userVo);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioVO update(@RequestBody UsuarioVO userVo) {
		return service.update(userVo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
