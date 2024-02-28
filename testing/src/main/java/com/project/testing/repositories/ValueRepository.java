package com.project.testing.repositories;

import com.project.testing.entities.Input;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface ValueRepository extends CrudRepository<Input, Integer> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE values", nativeQuery = true)
    void truncateTable();
}
