package com.project.testing.services;

import com.project.testing.entities.Input;
import com.project.testing.repositories.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueService {
    @Autowired
    private ValueRepository repo;

    public void save(Input value) {
        repo.save(value);
    }

    public void deleteAll() {
        repo.truncateTable();
    }

    public Input getInput(){
        if(repo.existsById(0)) {
           return repo.findById(0).get();
        }

        return null;
    }
}
