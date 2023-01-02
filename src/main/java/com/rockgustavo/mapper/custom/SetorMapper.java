package com.rockgustavo.mapper.custom;

import org.springframework.stereotype.Service;

import com.rockgustavo.data.vo.v1.SetorVO;
import com.rockgustavo.model.Setor;

@Service
public class SetorMapper {
	
	public SetorVO convertEntityToVo(Setor sector) {
		SetorVO sectorVo = new SetorVO();
		
		sectorVo.setSetor_id(sector.getSetor_id());
		sectorVo.setSituacao(sector.isSituacao());
		sectorVo.setNome(sector.getNome());
		sectorVo.setArea(sector.getArea());
		sectorVo.setDate_create(sector.getDate_create());
		sectorVo.setDate_update(sector.getDate_update());
		
		return sectorVo;
	}
	
	public Setor convertVoToEntity(SetorVO sectorVo) {
		Setor sector = new Setor();
		
		sector.setSetor_id(sectorVo.getSetor_id());
		sector.setSituacao(sectorVo.isSituacao());
		sector.setNome(sectorVo.getNome());
		sector.setArea(sectorVo.getArea());
		sector.setDate_create(sectorVo.getDate_create());
		sector.setDate_update(sectorVo.getDate_update());
		
		return sector;
	}

}
