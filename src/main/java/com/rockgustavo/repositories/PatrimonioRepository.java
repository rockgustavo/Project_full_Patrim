package com.rockgustavo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockgustavo.model.Patrimonio;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Integer> {

}
