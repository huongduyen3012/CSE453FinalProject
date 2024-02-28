package com.project.testing.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "inputs")
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "less_min")
    private int lessMin = -1;
    @Column(nullable = false)
    private int min;
    @Column(name = "greater_min")
    private int greaterMin;
    @Column(nullable = false)
    private int nom;
    @Column(name = "less_max")
    private int lessMax;
    @Column(nullable = false)
    private int max;
    @Column(name = "greater_max")
    private int greaterMax = -1;
    private String type;

    public void setValues(int min, int max) {
        this.min = min;
        this.max = max;
        greaterMin = min++;
        nom = (max + min) / 2;
        lessMax = max--;

        if (type.equals("robust")) {
            lessMin = min--;
            greaterMax = max++;
        }
    }

    public List<Integer> getInputAsList() {
        List<Integer> values = new ArrayList<>(Arrays.asList(min, greaterMin, nom, lessMax, max));

        if (type.equals("robust")) {
            values.addFirst(lessMin);
            values.addLast(greaterMax);
        }

        return values;
    }

    public Integer getId() {
        return id;
    }

    public int getLessMin() {
        return lessMin;
    }

    public int getGreaterMin() {
        return greaterMin;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getNom() {
        return nom;
    }

    public int getLessMax() {
        return lessMax;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getGreaterMax() {
        return greaterMax;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
