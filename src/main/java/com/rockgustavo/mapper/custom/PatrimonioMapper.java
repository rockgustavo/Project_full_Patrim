package com.rockgustavo.mapper.custom;

import org.springframework.stereotype.Service;

import com.rockgustavo.data.vo.v1.PatrimonioVO;
import com.rockgustavo.model.Patrimonio;

@Service
public class PatrimonioMapper {
	
	public PatrimonioVO convertEntityToVo(Patrimonio patrim) {
		PatrimonioVO patrimVo = new PatrimonioVO();
		
		patrimVo.setPatrim_id(patrim.getPatrim_id());
		patrimVo.setSituacao(patrim.isSituacao());
		patrimVo.setRegistro_interno(patrim.getRegistro_interno());
		patrimVo.setFoto_url_item(patrim.getFoto_url_item());
		patrimVo.setDescricao(patrim.getDescricao());
		patrimVo.setValor(patrim.getValor());
		patrimVo.setDados_comp(patrim.getDados_comp());
		patrimVo.setDados_baixa(patrim.getDados_baixa());
		patrimVo.setDate_baixa(patrim.getDate_baixa());
		patrimVo.setDate_create(patrim.getDate_create());
		patrimVo.setDate_update(patrim.getDate_update());
		
		return patrimVo;
	}
	
	public Patrimonio convertVoToEntity(PatrimonioVO patrimVo) {
		Patrimonio patrim = new Patrimonio();
		
		patrim.setPatrim_id(patrimVo.getPatrim_id());
		patrim.setSituacao(patrimVo.isSituacao());
		patrim.setRegistro_interno(patrimVo.getRegistro_interno());
		patrim.setFoto_url_item(patrimVo.getFoto_url_item());
		patrim.setDescricao(patrimVo.getDescricao());
		patrim.setValor(patrimVo.getValor());
		patrim.setDados_comp(patrimVo.getDados_comp());
		patrim.setDados_baixa(patrimVo.getDados_baixa());
		patrim.setDate_baixa(patrimVo.getDate_baixa());
		patrim.setDate_create(patrimVo.getDate_create());
		patrim.setDate_update(patrimVo.getDate_update());
		
		return patrim;
	}

}
