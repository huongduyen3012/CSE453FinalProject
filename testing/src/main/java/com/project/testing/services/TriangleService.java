package com.project.testing.services;

import com.project.testing.entities.Input;
import com.project.testing.entities.Triangle;
import com.project.testing.repositories.TriangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class TriangleService {
    @Autowired
    private TriangleRepository repo;

    private List<Integer> values = new LinkedList<>();

    public List<Triangle> listAll() {
        return (List<Triangle>) repo.findAll();
    }

    public void save(Triangle triangle) {
        repo.save(triangle);
    }

    public void deleteAll() {
        repo.truncateTable();
    }

    public void execute(Input input) {
        this.deleteAll();
        this.values = input.getInputAsList();

        if (input.getType().equalsIgnoreCase("robust")) {
            this.values.addFirst(this.values.getFirst() - 1);
            this.values.addLast(this.values.getLast() + 1);
        }
        for (int i = 0; i < 4; i++) {
            generateTestCases(this.values.size(), i);
        }
    }


    private void generateTestCases(int size, int location) {
        int nom = values.get(values.size() / 2);

        if (location == 0) {
            Triangle triangle = new Triangle();
            triangle.setSide(nom, nom, nom);
            triangle.setType();
            repo.save(triangle);
            return;
        }

        for (int i = 0; i < size; i++) {
            Triangle triangle = new Triangle();
            triangle.setSide(nom, nom, nom);

            if (location == 1) {
                triangle.setSide1(values.get(i));
            } else if (location == 2) {
                triangle.setSide2(values.get(i));
            } else {
                triangle.setSide3(values.get(i));
            }

            triangle.setType();
            repo.save(triangle);
        }
    }
}
