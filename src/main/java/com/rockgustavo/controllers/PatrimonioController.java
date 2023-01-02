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

import com.rockgustavo.data.vo.v1.PatrimonioVO;
import com.rockgustavo.services.PatrimonioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/patrimonio")
@Tag(name = "Patrimonio", description = "Endpoints for Managing Patrim")
public class PatrimonioController {
	
	@Autowired
	private PatrimonioService service;
	
	@Operation(summary = "Finds all patrims", description = "Method for finds all patrims")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PatrimonioVO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PatrimonioVO findById(@PathVariable(value = "id") Integer id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PatrimonioVO create(@RequestBody PatrimonioVO patrimVo) {
		return service.create(patrimVo);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PatrimonioVO update(@RequestBody PatrimonioVO patrimVo) {
		return service.update(patrimVo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
