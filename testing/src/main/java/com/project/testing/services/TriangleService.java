package com.project.testing.services;

import com.project.testing.entities.Triangle;
import com.project.testing.repositories.TriangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TriangleService {
    @Autowired
    private TriangleRepository repo;

    public List<Triangle> listAll() {
        return (List<Triangle>) repo.findAll();
    }

    public void excute(String testType) {
        repo.truncateTable();
        for (int i = 0; i < 4; i++) {
            if (testType.equals("normal")) {
                generateTestCases(i, Arrays.asList(10, 11, 219, 220));
            } else {
                generateTestCases(i, Arrays.asList(9, 10, 11, 219, 220, 221));
            }
        }
    }

    private void generateTestCases(int location, List<Integer> values) {
        switch (location) {
            case 1:
                for (Integer value : values) {
                    Triangle triangle = new Triangle();
                    triangle.setSide(value, 115, 115);
                    triangle.setType();
                    repo.save(triangle);
                }
                break;
            case 2:
                for (Integer value : values) {
                    Triangle triangle = new Triangle();
                    triangle.setSide(115, value, 115);
                    triangle.setType();
                    repo.save(triangle);
                }
                break;
            case 3:
                for (Integer value : values) {
                    Triangle triangle = new Triangle();
                    triangle.setSide(115, 115, value);
                    triangle.setType();
                    repo.save(triangle);
                }
                break;
            default:
                Triangle triangle = new Triangle();
                triangle.setSide(115, 115, 115);
                triangle.setType();
                repo.save(triangle);
        }
    }
}
