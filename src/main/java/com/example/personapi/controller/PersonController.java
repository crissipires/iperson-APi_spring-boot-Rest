package com.example.personapi.controller;


import com.example.personapi.dto.MessageResponseDTO;
import com.example.personapi.entity.Person;
import com.example.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/pessoa")
public class PersonController {

    private PersonRepository personRepository;

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person personCreated = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Person created with id = " + personCreated.getId())
                .build();
    }

}
