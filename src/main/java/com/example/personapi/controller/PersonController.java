package com.example.personapi.controller;


import com.example.personapi.dto.MessageResponseDTO;
import com.example.personapi.entity.Person;
import com.example.personapi.repository.PersonRepository;
import com.example.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/pessoa")
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

}
