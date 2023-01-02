package com.rockgustavo.mapper.custom;

import org.springframework.stereotype.Service;

import com.rockgustavo.data.vo.v1.UsuarioVO;
import com.rockgustavo.model.Usuario;

@Service
public class UsuarioMapper {
	
	public UsuarioVO convertEntityToVo(Usuario user) {
		UsuarioVO userVo = new UsuarioVO();
		
		userVo.setUser_id(user.getUser_id());
		userVo.setSituacao(user.isSituacao());
		userVo.setCargo(user.getCargo());
		userVo.setNome(user.getNome());
		userVo.setRg(user.getRg());
		userVo.setCpf(user.getCpf());
		userVo.setLogin(user.getLogin());
		userVo.setSenha(user.getSenha());
		userVo.setDate_create(user.getDate_create());
		userVo.setDate_update(user.getDate_update());
		
		return userVo;
	}
	
	public Usuario convertVoToEntity(UsuarioVO userVo) {
		Usuario user = new Usuario();
		
		user.setUser_id(userVo.getUser_id());
		user.setSituacao(userVo.isSituacao());
		user.setCargo(userVo.getCargo());
		user.setNome(userVo.getNome());
		user.setRg(userVo.getRg());
		user.setCpf(userVo.getCpf());
		user.setLogin(userVo.getLogin());
		user.setSenha(userVo.getSenha());
		user.setDate_create(userVo.getDate_create());
		user.setDate_update(userVo.getDate_update());
		
		return user;
	}

}
