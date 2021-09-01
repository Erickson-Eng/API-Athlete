package com.example.apiathlete.service;

import com.example.apiathlete.domain.State;
import com.example.apiathlete.repository.StateRepository;
import com.example.apiathlete.service.exceptions.DataIntegrityViolationException;
import com.example.apiathlete.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {


    private StateRepository repository;

    @Autowired
    public StateService(StateRepository repository) {
        this.repository = repository;
    }

    public State findById(Integer id){
        Optional<State> obj = repository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Estado não encontrado! id: " + id + ", Tipo: "+ State.class.getName()
        ));
    }

    public List<State> findAll(){
        return repository.findAll();
    }

    public State insert( State state){
        return repository.save(state);
    }

    public void delete (Integer id){
        findById(id);
        try{
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possivel excluir um estado vinculado a uma cidade");
        }

    }
    public State update(Integer id, State state){
        State newState = findById(id);
        updateData(newState, state);
        return repository.save(newState);
    }
    private void updateData(State newState, State state) {
        newState.setStateName(state.getStateName());
        newState.setUf(state.getUf());
    }
}