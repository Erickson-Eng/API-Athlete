package com.example.apiathlete.service;


import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.repository.AthleteRepository;
import com.example.apiathlete.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AthleteService {

    private AthleteRepository repository;

    @Autowired
    public AthleteService(AthleteRepository repository) {
        this.repository = repository;
    }

    public Athlete findById(Integer id){
        Optional<Athlete> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Atleta não encontrado! Id: "+ id + Athlete.class.getName()
        ));
    }

    public List<Athlete> findAll(){
        return repository.findAll();
    }

    public void insert(Athlete obj){
        repository.save(obj);
    }

    public void delete(Integer id){
        findById(id);
        repository.deleteById(id);
    }

    public Athlete update(Integer id, Athlete obj){
        Athlete newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }
    private void updateData(Athlete newObj, Athlete obj) {
        newObj.setFirstName(obj.getFirstName());
        newObj.setLastName(obj.getLastName());
        newObj.setHeight(obj.getHeight());
        newObj.setWeight(obj.getWeight());
    }
}
