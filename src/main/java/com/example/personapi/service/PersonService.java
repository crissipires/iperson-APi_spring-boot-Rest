package com.example.personapi.service;

import com.example.personapi.dto.MessageResponseDTO;
import com.example.personapi.entity.Person;
import com.example.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;


    public MessageResponseDTO savePerson(Person person){
        Person personCreated = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Person created with id = " + personCreated.getId())
                .build();
    }

}
