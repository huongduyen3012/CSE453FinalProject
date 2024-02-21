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
    @Autowired
    private TriangleRepository repo;

    public List<Triangle> listAll() {
        return (List<Triangle>) repo.findAll();
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public void generateTestCases() {
        int[] values = new int[]{10, 11, 115, 219, 220};
        Triangle triangle = new Triangle();
        triangle.setSide(115,115,115);
        triangle.setType();
        repo.save(triangle);

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                for (int k = 0; k < values.length; k++) {
                    if(values[i] != values[j] && values[i] != values[k]) {
                        triangle = new Triangle();
                        triangle.setSide(values[i], values[j], values[k]);
                        triangle.setType();
                        repo.save(triangle);
                    }
                }
            }
        }
    }

//    private Triangle
}
