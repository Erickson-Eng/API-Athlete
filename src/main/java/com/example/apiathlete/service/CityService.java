package com.example.apiathlete.service;

import com.example.apiathlete.domain.City;
import com.example.apiathlete.repository.CityRepository;
import com.example.apiathlete.service.exceptions.DataIntegrityViolationException;
import com.example.apiathlete.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private CityRepository repository;

    @Autowired
    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public City findById(Integer id){
        Optional<City> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Cidade não encontrada! Id: "+id+ City.class.getName()
        ));
    }

    public List<City> findAll(){
        return repository.findAll();
    }

    public City insert( City city){
        try{
            return repository.save(city);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possivel incluir uma cidade sem nome");
        }
    }

    public void delete(Integer id){
        findById(id);
        try{
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possivel excluir cidades vinculadas a endereços");
        }
    }

    public City update(Integer id, City obj){
        City newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }
    private void updateData(City newObj, City obj) {
        newObj.setCityName(obj.getCityName());
    }

}
