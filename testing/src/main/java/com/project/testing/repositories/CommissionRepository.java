package com.project.testing.repositories;

import com.project.testing.entities.Commission;
import org.springframework.data.repository.CrudRepository;

public interface CommissionRepository extends CrudRepository<Commission, Integer> {
}
