package com.rockgustavo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockgustavo.data.vo.v1.UsuarioVO;
import com.rockgustavo.exceptions.ResourceNotFoundException;
import com.rockgustavo.mapper.DozerMapper;
import com.rockgustavo.model.Patrimonio;
import com.rockgustavo.model.Usuario;
import com.rockgustavo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private Logger logger = Logger.getLogger(Patrimonio.class.getName());

	@Autowired
	UsuarioRepository repository;
	
	public List<UsuarioVO>  findAll() {
		logger.info("Finding all");
		return DozerMapper.parseListObjects(repository.findAll(), UsuarioVO.class);
	}

	public UsuarioVO findById(Integer id) {
		logger.info("Finding one user");
		var result = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(result, UsuarioVO.class);
	}
	
	public UsuarioVO findByAuth(UsuarioVO userVo) {
		logger.info("Authentication");
		var result = repository.findByLogin(userVo.getLogin());
		var vo = DozerMapper.parseObject(result, UsuarioVO.class);
		return vo;
	}

	public UsuarioVO create(UsuarioVO userVo) {
		logger.info("Creating one patrim");
		var result = DozerMapper.parseObject(userVo, Usuario.class);
		var vo = DozerMapper.parseObject(repository.save(result), UsuarioVO.class);
		return vo;
	}

	public UsuarioVO update(UsuarioVO userVo) {
		logger.info("Update one user");
		var result = repository.findById(userVo.getUser_id())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		result.setSituacao(userVo.isSituacao());
		result.setCargo(userVo.getCargo());
		result.setNome(userVo.getNome());
		result.setRg(userVo.getRg());
		result.setCpf(userVo.getCpf());
		result.setLogin(userVo.getLogin());
		result.setSenha(userVo.getSenha());
		result.setDate_create(userVo.getDate_create());
		result.setDate_update(userVo.getDate_update());
		result.setSetor(userVo.getSetor());
		
		var vo = DozerMapper.parseObject(repository.save(result), UsuarioVO.class);
		return vo;
	}

	public void delete(Integer id) {
		logger.info("Deleting one user");
		var result = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(result);
	}
}