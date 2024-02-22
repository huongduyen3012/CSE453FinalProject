package com.project.testing.services;

import com.project.testing.entities.Commission;
import com.project.testing.entities.Triangle;
import com.project.testing.repositories.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommissionService {
    @Autowired
    private CommissionRepository repo;

    public List<Commission> listAll() {
        return (List<Commission>) repo.findAll();
    }

    public void save(Commission commission) {
        repo.save(commission);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public List<Commission> generateTestCases() {
        List<Commission> testCases = new ArrayList<>();

        return testCases;
    }
}
