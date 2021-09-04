package com.example.apiathlete.service;


import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.dto.mapper.AthleteMapper;
import com.example.apiathlete.dto.request.AthleteDTO;
import com.example.apiathlete.repository.AthleteRepository;
import com.example.apiathlete.service.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AthleteService {

    private final AthleteRepository repository;

    private final AthleteMapper mapper;



    public AthleteDTO findById(Integer id){
        Athlete obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Atleta não encontrado! Id: "+ id + Athlete.class.getName()));
        return mapper.toDTO(obj);
    }

    public List<AthleteDTO> findAll(){
        return repository.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    public void insert(AthleteDTO obj){
        Athlete athlete = mapper.toModel(obj);
        repository.save(athlete);
    }

    public void delete(Integer id){
        findById(id);
        repository.deleteById(id);
    }

    public void replace(Integer id, AthleteDTO obj){
        AthleteDTO newObj = findById(id);
        updateData(newObj,obj);
        Athlete updateAthlete = mapper.toModel(newObj);
        repository.save(updateAthlete);
    }
    private void updateData(AthleteDTO newObj, AthleteDTO obj) {
        newObj.setFirstName(obj.getFirstName());
        newObj.setLastName(obj.getLastName());
        newObj.setHeight(obj.getHeight());
        newObj.setWeight(obj.getWeight());
    }
}
