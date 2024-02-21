package com.project.testing.services;

import com.project.testing.entities.BoundaryValue;
import com.project.testing.entities.Triangle;
import com.project.testing.repositories.TriangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TriangleService {
    @Autowired private TriangleRepository repo;

    public List<Triangle> listAll(){
        return (List<Triangle>) repo.findAll();
    }

    public void save(Triangle triangle){
        repo.save(triangle);
    }

    public void deleteAll(){
        repo.deleteAll();
    }

    public List<Triangle> generateTestCases(){
        List<Triangle> testCases = new ArrayList<>();



        return  testCases;
    }
}
