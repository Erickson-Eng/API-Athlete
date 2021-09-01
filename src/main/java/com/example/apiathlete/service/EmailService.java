package com.example.apiathlete.service;


import com.example.apiathlete.domain.Email;
import com.example.apiathlete.repository.EmailRepository;
import com.example.apiathlete.service.exceptions.DataIntegrityViolationException;
import com.example.apiathlete.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    private EmailRepository repository;

    @Autowired
    public EmailService(EmailRepository repository) {
        this.repository = repository;
    }

    public Email findById(Integer id){
        Optional<Email> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Email não encontrado! Id: "+ id + Email.class.getName()
        ));
    }

    public List<Email> findAll(){
        return repository.findAll();
    }

    public Email insert(Email obj){
        try {
            return repository.save(obj);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Email invalido");
        }
    }

    public void delete(Integer id){
        findById(id);
        repository.deleteById(id);
    }

    public Email update(Integer id, Email obj){
        Email newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }
    private void updateData(Email newObj, Email obj) {
        newObj.setAddressEmail(obj.getAddressEmail());
    }
}
