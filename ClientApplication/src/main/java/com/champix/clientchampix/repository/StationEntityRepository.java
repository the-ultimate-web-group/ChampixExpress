package com.champix.clientchampix.repository;

import com.champix.clientchampix.domains.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationEntityRepository extends JpaRepository<StationEntity, Integer> {

    public List<StationEntity> findAll();

}