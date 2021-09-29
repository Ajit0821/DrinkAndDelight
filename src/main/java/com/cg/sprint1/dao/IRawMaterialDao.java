package com.cg.sprint1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.sprint1.entity.RawMaterial;

public interface IRawMaterialDao extends JpaRepository<RawMaterial, Integer> {

}
