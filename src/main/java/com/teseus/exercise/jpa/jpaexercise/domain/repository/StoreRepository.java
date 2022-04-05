package com.teseus.exercise.jpa.jpaexercise.domain.repository;

import com.teseus.exercise.jpa.jpaexercise.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
