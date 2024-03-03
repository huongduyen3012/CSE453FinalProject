package com.project.testing.services;

import com.project.testing.entities.Commission;
import com.project.testing.repositories.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class CommissionService {
    @Autowired
    private CommissionRepository repo;

    private List<Integer> lockValues = new LinkedList<>(Arrays.asList(1, 2, 59, 60));
    private List<Integer> stockValues = new LinkedList<>(Arrays.asList(1, 2, 69, 70));
    private List<Integer> barrelValues = new LinkedList<>(Arrays.asList(1, 2, 79, 80));

    public List<Commission> listAll() {
        return (List<Commission>) repo.findAll();
    }

    public void save(Commission commission) {
        repo.save(commission);
    }

    public void deleteAll() {
        repo.truncateTable();
    }

    public void execute(String testType) {
        this.deleteAll();

        if (testType.equalsIgnoreCase("robust")) {
            lockValues.addFirst(lockValues.getFirst() - 1);
            lockValues.addLast(lockValues.getLast() + 1);
            stockValues.addFirst(stockValues.getFirst() - 1);
            stockValues.addLast(stockValues.getLast() + 1);
            barrelValues.addFirst(barrelValues.getFirst() - 1);
            barrelValues.addLast(barrelValues.getLast() + 1);
        }

        for (int i = 0; i < 4; i++) {
            generateTestCases(stockValues.size(), i);
        }
    }

    private void generateTestCases(int size, int type) {
        if (type == 0) {
            Commission commission = new Commission();
            commission.setInput(30, 35, 40);
            commission.setCommission();
            repo.save(commission);
            return;
        }

        for (int i = 0; i < size; i++) {
            Commission commission = new Commission();
            commission.setInput(30, 35, 40);

            if (type == 1) {
                commission.setTotalLocks(lockValues.get(i));
            } else if (type == 2) {
                commission.setTotalStocks(stockValues.get(i));
            } else {
                commission.setTotalBarrales(barrelValues.get(i));
            }

            commission.setCommission();
            repo.save(commission);
        }
    }
}
