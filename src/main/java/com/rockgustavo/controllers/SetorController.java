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

import com.rockgustavo.data.vo.v1.SetorVO;
import com.rockgustavo.services.SetorService;

@CrossOrigin
@RestController
@RequestMapping("/setor")
public class SetorController {
	
	@Autowired
	private SetorService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SetorVO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SetorVO findById(@PathVariable(value = "id") Integer id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SetorVO create(@RequestBody SetorVO setorVo) {
		return service.create(setorVo);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SetorVO update(@RequestBody SetorVO setorVo) {
		return service.update(setorVo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
