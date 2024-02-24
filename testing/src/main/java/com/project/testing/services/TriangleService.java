package com.project.testing.services;

import com.project.testing.entities.Triangle;
import com.project.testing.repositories.TriangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriangleService {
    @Autowired
    private TriangleRepository repo;

    public List<Triangle> listAll() {
        return (List<Triangle>) repo.findAll();
    }

    public void generateTestCases(String testType) {
        repo.truncateTable();
        if (testType.equals("normal")) {
            for (int i = 0; i < 4; i++) {
                normalValues(i);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                robustValues(i);
            }
        }
    }

    private void normalValues(int run) {
        int[] values = new int[]{10, 11, 219, 220};

        switch (run) {
            case 1:
                for (int i = 0; i < values.length; i++) {
                    Triangle triangle = new Triangle();
                    triangle.setSide(values[i], 115, 115);
                    triangle.setType();
                    repo.save(triangle);
                }
                break;
            case 2:
                for (int i = 0; i < values.length; i++) {
                    Triangle triangle = new Triangle();
                    triangle.setSide(115, values[i], 115);
                    triangle.setType();
                    repo.save(triangle);
                }
                break;
            case 3:
                for (int i = 0; i < values.length; i++) {
                    Triangle triangle = new Triangle();
                    triangle.setSide(115, 115, values[i]);
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

    private void robustValues(int run) {
        int[] values = new int[]{9, 10, 11, 219, 220, 221};

        switch (run) {
            case 1:
                for (int i = 0; i < values.length; i++) {
                    Triangle triangle = new Triangle();
                    triangle.setSide(values[i], 115, 115);
                    triangle.setType();
                    repo.save(triangle);
                }
                break;
            case 2:
                for (int i = 0; i < values.length; i++) {
                    Triangle triangle = new Triangle();
                    triangle.setSide(115, values[i], 115);
                    triangle.setType();
                    repo.save(triangle);
                }
                break;
            case 3:
                for (int i = 0; i < values.length; i++) {
                    Triangle triangle = new Triangle();
                    triangle.setSide(115, 115, values[i]);
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
