package com.project.testing.services;

import com.project.testing.entities.BoundaryValue;
import com.project.testing.repositories.BoundaryValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoundaryValueService {
    @Autowired private BoundaryValueRepository repo;

    public void save(BoundaryValue value){
        repo.save(value);
    }

    public void clear(){
        repo.deleteAll();
    }

    private BoundaryValue getValueById(Integer id) throws ValueNotFoundException {
        Optional<BoundaryValue> result = repo.findById(id);

        if(result.isPresent()){
            return result.get();
        }

        throw new ValueNotFoundException("Could not found boundary value");
    }

    public List<Integer> getValuesList(Integer id) throws ValueNotFoundException {
        List<Integer> values = new ArrayList<>();
        BoundaryValue boundaryValue = getValueById(id);

        return  values;
    }
}
