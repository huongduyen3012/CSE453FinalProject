package com.project.testing.repositories;

import com.project.testing.entities.Triangle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface TriangleRepository extends CrudRepository<Triangle, Integer> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE triangles", nativeQuery = true)
    void truncateTable();
}
