package com.glaucuslogistics.glaucuslogistics.repository;

import com.glaucuslogistics.glaucuslogistics.model.Incrementer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IncrementerRepository extends JpaRepository<Incrementer, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE incrementer i set i.id = i.id + 1", nativeQuery = true)
    int incrementValue();
}
