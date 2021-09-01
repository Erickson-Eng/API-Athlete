package com.example.apiathlete.service;

import com.example.apiathlete.domain.Address;
import com.example.apiathlete.repository.AddressRepository;
import com.example.apiathlete.service.exceptions.DataIntegrityViolationException;
import com.example.apiathlete.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public Address findById(Integer id){
        Optional<Address> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Endereco não encontrado! Id: "+ id + Address.class.getName()
        ));
    }

    public List<Address> findAll(){
        return repository.findAll();
    }

    public Address insert(Address address){
        try {
          return repository.save(address);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possivel salvar uma rua sem nome ou cep");
        }
    }

    public void delete(Integer id){
        findById(id);
        repository.deleteById(id);
    }

    public Address update(Integer id, Address obj){
        Address newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }
    private void updateData(Address newObj, Address obj) {
        newObj.setStreetName(obj.getStreetName());
        newObj.setComplement(obj.getComplement());
        newObj.setCep(obj.getCep());
    }
}
