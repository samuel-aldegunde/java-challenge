package com.intelygenz.repository;

import com.intelygenz.domain.model.IntegerSorterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinaryIntegerSorterRepository extends JpaRepository<IntegerSorterEntity, Integer> {
}
