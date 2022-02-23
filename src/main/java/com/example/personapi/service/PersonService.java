package com.example.personapi.service;

import com.example.personapi.dto.MessageResponseDTO;
import com.example.personapi.dto.request.PersonDTO;
import com.example.personapi.entity.Person;
import com.example.personapi.mapper.PersonMapper;
import com.example.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO savePerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Person created with id = " + savedPerson.getId())
                .build();
    }

}
