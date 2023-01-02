package com.rockgustavo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockgustavo.data.vo.v1.PatrimonioVO;
import com.rockgustavo.exceptions.ResourceNotFoundException;
import com.rockgustavo.mapper.DozerMapper;
import com.rockgustavo.model.Patrimonio;
import com.rockgustavo.repositories.PatrimonioRepository;

@Service
public class PatrimonioService {
	
	private Logger logger = Logger.getLogger(Patrimonio.class.getName());

	@Autowired
	PatrimonioRepository repository;
	
	public List<PatrimonioVO>  findAll() {
		logger.info("Finding all");
		return DozerMapper.parseListObjects(repository.findAll(), PatrimonioVO.class);
	}

	public PatrimonioVO findById(Integer id) {
		logger.info("Finding one patrim");
		var result = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(result, PatrimonioVO.class);
	}

	public PatrimonioVO create(PatrimonioVO patrimVo) {
		logger.info("Creating one patrim");
		var result = DozerMapper.parseObject(patrimVo, Patrimonio.class);
		var vo = DozerMapper.parseObject(repository.save(result), PatrimonioVO.class);
		return vo;
	}

	public PatrimonioVO update(PatrimonioVO patrimVo) {
		logger.info("Update one patrim");
		var result = repository.findById(patrimVo.getPatrim_id())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		result.setSituacao(patrimVo.isSituacao());
		result.setRegistro_interno(patrimVo.getRegistro_interno());
		result.setFoto_url_item(patrimVo.getFoto_url_item());
		result.setDescricao(patrimVo.getDescricao());
		result.setValor(patrimVo.getValor());
		result.setDados_comp(patrimVo.getDados_comp());
		result.setDados_baixa(patrimVo.getDados_baixa());
		result.setDate_baixa(patrimVo.getDate_baixa());
		result.setDate_create(patrimVo.getDate_create());
		result.setDate_update(patrimVo.getDate_update());
		
		var vo = DozerMapper.parseObject(repository.save(result), PatrimonioVO.class);
		return vo;
	}

	public void delete(Integer id) {
		logger.info("Deleting one patrim");
		var result = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(result);
	}
}