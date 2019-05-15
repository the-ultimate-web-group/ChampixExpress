package com.champix.adminchampix.repository;

import com.champix.adminchampix.domains.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationEntityRepository extends JpaRepository<StationEntity, Integer> {

    public List<StationEntity> findAll();

}