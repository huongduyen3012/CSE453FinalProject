package com.project.testing.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "triangles")
public class Triangle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int side1;

    @Column(nullable = false)
    private int side2;

    @Column(nullable = false)
    private int side3;

    @Column(nullable = false)
    private String type;

    public void setSide(int s1, int s2, int s3) {
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }

    public boolean isTriangle() {
        return (side1 < side2 + side3) && (side2 < side1 + side3) && (side3 < side2 + side1);
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType() {
        this.type = classify();
    }

    public String classify() {
        boolean c1 = (1 <= side1) && (side1 <= 220);
        boolean c2 = (1 <= side2) && (side2 <= 220);
        boolean c3 = (1 <= side3) && (side3 <= 220);

        if (!c1 || !c2 || !c3)
            return "OUT_OF_RANGE";
        if (isTriangle()) {
            if ((side1 == side2) && (side2 == side3))
                return "EQUILATERAL";
            else if ((side1 != side2) && (side1 != side3) && (side2 != side3))
                return "SCALENE";
            else
                return "ISOSCELES";
        }
        return "IsNotTriangle";
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", type='" + type + '\'' +
                '}';
    }
}

