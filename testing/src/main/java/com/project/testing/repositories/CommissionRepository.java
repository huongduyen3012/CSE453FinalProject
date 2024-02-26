package com.project.testing.repositories;

import com.project.testing.entities.Commission;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CommissionRepository extends CrudRepository<Commission, Integer> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE commissions", nativeQuery = true)
    void truncateTable();
}
