package com.rockgustavo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockgustavo.data.vo.v1.SetorVO;
import com.rockgustavo.exceptions.ResourceNotFoundException;
import com.rockgustavo.mapper.DozerMapper;
import com.rockgustavo.model.Patrimonio;
import com.rockgustavo.model.Setor;
import com.rockgustavo.repositories.SetorRepository;

@Service
public class SetorService {
	
	private Logger logger = Logger.getLogger(Patrimonio.class.getName());

	@Autowired
	SetorRepository repository;
	
	public List<SetorVO>  findAll() {
		logger.info("Finding all");
		return DozerMapper.parseListObjects(repository.findAll(), SetorVO.class);
	}

	public SetorVO findById(Integer id) {
		logger.info("Finding one sector");
		var result = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(result, SetorVO.class);
	}

	public SetorVO create(SetorVO setorVo) {
		logger.info("Creating one sector");
		var result = DozerMapper.parseObject(setorVo, Setor.class);
		var vo = DozerMapper.parseObject(repository.save(result), SetorVO.class);
		return vo;
	}

	public SetorVO update(SetorVO setorVo) {
		logger.info("Update one sector");
		var result = repository.findById(setorVo.getSetor_id())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		result.setSituacao(setorVo.isSituacao());
		result.setNome(setorVo.getNome());
		result.setArea(setorVo.getArea());
		result.setDate_create(setorVo.getDate_create());
		result.setDate_update(setorVo.getDate_update());
		
		var vo = DozerMapper.parseObject(repository.save(result), SetorVO.class);
		return vo;
	}

	public void delete(Integer id) {
		logger.info("Deleting one sector");
		var result = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(result);
	}
}