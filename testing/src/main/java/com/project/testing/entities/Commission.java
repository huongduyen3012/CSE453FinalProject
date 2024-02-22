package com.project.testing.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "commission")
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private int totalLocks;
    @Column(nullable = false)
    private int totalStocks;
    @Column(nullable = false)
    private int totalBarrales;
    private double lockPrice;
    private double stockPrice;
    private double barralesPrice;

    public Commission() {
        lockPrice = 45.0;
        stockPrice = 30.0;
        barralesPrice = 25.0;
    }

    public void setInput(int locks, int stocks, int barrales) {
        this.totalLocks = locks;
        this.totalStocks = stocks;
        this.totalBarrales = barrales;
    }

    public int getTotalLocks() {
        return totalLocks;
    }

    public int getTotalStocks() {
        return totalStocks;
    }

    public int getTotalBarrales() {
        return totalBarrales;
    }

    public double calSale() {
        double lockSales = lockPrice * totalLocks;
        double stockSales = stockPrice * totalStocks;
        double barraelSale = barralesPrice * totalBarrales;

        return lockSales + stockSales + barraelSale;
    }

    public double calCommission(double sales) {
        double commission;
        boolean c1 = (1 <= totalLocks) && (totalLocks <= 70);
        boolean c2 = (1 <= totalStocks) && (totalStocks <= 80);
        boolean c3 = (1 <= totalBarrales) && (totalBarrales <= 90);

        if (!c1 || !c2 || !c3)
            commission = 0.0;
        else {
            if (sales > 1800) {
                commission = 0.10 * 1000.0;
                commission = commission + 0.15 * 800;
                commission = commission + 0.20 * (sales - 1800.0);
            } else if (sales > 1000) {
                commission = 0.10 * 1000;
                commission = commission + 0.15 * (sales - 1000);
            } else
                commission = 0.10 * sales;
        }
        return commission;
    }
}