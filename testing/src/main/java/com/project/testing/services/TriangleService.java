package com.project.testing.services;

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
    private List<Integer> edgeValues;
    public TriangleService(List<Integer> edgeValues) {
        this.edgeValues = edgeValues;
    }

    public List<Triangle> listAll() {
        return (List<Triangle>) repo.findAll();
    }

    public void save(Triangle triangle) {
        repo.save(triangle);
    }

    public void deleteAll() {
        repo.truncateTable();
    }

    public void execute(String testType, int from, int to) {
        this.deleteAll();
        this.edgeValues = new LinkedList<>(Arrays.asList(from, from + 1, to - 1, to));

        if (testType.equalsIgnoreCase("robust")) {
            edgeValues.addFirst(edgeValues.getFirst() - 1);
            edgeValues.addLast(edgeValues.getLast() + 1);
        }

        for (int i = 0; i < 4; i++) {
            generateTestCases(edgeValues.size(), i, from, to);
        }
    }

    private void generateTestCases(int size, int type, int from, int to) {
        int nom = (from + to) / 2;
        if (type == 0) {
            Triangle triangle = new Triangle();
            triangle.setSide(nom, nom, nom);
            triangle.setType();
            repo.save(triangle);
            return;
        }

        for (int i = 0; i < size; i++) {
            Triangle triangle = new Triangle();

            if (type == 1) {
                triangle.setSide(edgeValues.get(i), nom, nom);
            } else if (type == 2) {
                triangle.setSide(nom, edgeValues.get(i), nom);
            } else {
                triangle.setSide(nom, nom, edgeValues.get(i));
            }

            triangle.setType();
            repo.save(triangle);
        }
    }
}
