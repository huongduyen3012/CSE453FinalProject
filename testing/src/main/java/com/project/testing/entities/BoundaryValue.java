package com.project.testing.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "boundary_values")
public class BoundaryValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 15)
    private String type;
    @Column(nullable = false)
    private int min;

    @Column(nullable = false)
    private int max;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLessMin() {
        return min--;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getGreaterMin() {
        return min++;
    }

    public int getNom() {
        return (min + max)/2;
    }

    public int getLessMax() {
        return max--;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getGreaterMax() {
            return max++;
    }
}
