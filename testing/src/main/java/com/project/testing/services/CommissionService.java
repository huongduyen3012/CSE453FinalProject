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
    private final CommissionRepository repo;
    private  List<Integer> lockValues;
    private  List<Integer> stockValues;
    private  List<Integer> barrelValues;

    public CommissionService(CommissionRepository repo, List<Integer> lockValues, List<Integer> stockValues, List<Integer> barrelValues) {
        this.repo = repo;
        this.lockValues = lockValues;
        this.stockValues = stockValues;
        this.barrelValues = barrelValues;
    }

    public List<Commission> listAll() {
        return (List<Commission>) repo.findAll();
    }

    public void save(Commission commission) {
        repo.save(commission);
    }

    public void deleteAll() {
        repo.truncateTable();
    }

    public void execute(String testType, int fromLock, int toLock,
                        int fromStock, int toStock, int fromBarrel, int toBarrel) {
        this.deleteAll();

        lockValues = new LinkedList<>(Arrays.asList(fromLock, fromLock + 1, toLock - 1, toLock));
        stockValues = new LinkedList<>(Arrays.asList(fromStock, fromStock + 1, toStock - 1, toStock));
        barrelValues = new LinkedList<>(Arrays.asList(fromBarrel, fromBarrel + 1, toBarrel - 1, toBarrel));

        if (testType.equalsIgnoreCase("robust")) {
            lockValues.addFirst(lockValues.getFirst() - 1);
            lockValues.addLast(lockValues.getLast() + 1);
            stockValues.addFirst(stockValues.getFirst() - 1);
            stockValues.addLast(stockValues.getLast() + 1);
            barrelValues.addFirst(barrelValues.getFirst() - 1);
            barrelValues.addLast(barrelValues.getLast() + 1);
        }

        for (int i = 0; i < 4; i++) {
            generateTestCases(stockValues.size(), i, fromLock, toLock, fromStock, toStock, fromBarrel, toBarrel);
        }
    }

    private void generateTestCases(int size, int type, int fromLock, int toLock,
                                   int fromStock, int toStock, int fromBarrel, int toBarrel) {
        int nomLock = (fromLock + toLock) / 2;
        int nomStock = (fromStock + toStock) / 2;
        int nomBarrel = (fromBarrel + toBarrel) / 2;

        if (type == 0) {
            Commission commission = new Commission();
            commission.setInput(nomLock, nomStock, nomBarrel);
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
