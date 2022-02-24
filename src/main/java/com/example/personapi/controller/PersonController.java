package com.example.personapi.controller;


import com.example.personapi.dto.MessageResponseDTO;
import com.example.personapi.dto.request.PersonDTO;
import com.example.personapi.exception.NotFoundPersonException;
import com.example.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/pessoa")
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.savePerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO personById(@PathVariable Long id) throws NotFoundPersonException {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonById(@PathVariable Long id) throws NotFoundPersonException {
        personService.deleteById(id);
    }

}
