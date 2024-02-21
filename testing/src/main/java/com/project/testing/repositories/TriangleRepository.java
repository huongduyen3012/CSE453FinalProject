package com.project.testing.repositories;

import com.project.testing.entities.Triangle;
import org.springframework.data.repository.CrudRepository;

public interface TriangleRepository extends CrudRepository<Triangle, Integer> {
}
