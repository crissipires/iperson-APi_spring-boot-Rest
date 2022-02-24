package com.example.personapi.service;

import com.example.personapi.dto.MessageResponseDTO;
import com.example.personapi.dto.request.PersonDTO;
import com.example.personapi.entity.Person;
import com.example.personapi.exception.NotFoundPersonException;
import com.example.personapi.mapper.PersonMapper;
import com.example.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PersonDTO> listAll() {
        List<Person> personList = personRepository.findAll();
        return personList.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());

    }

    public PersonDTO getPersonById(Long id) throws NotFoundPersonException {
        Person personById = verifyIfExist(id);
        return personMapper.toDTO(personById);
    }

    public void deleteById(Long id) throws NotFoundPersonException {
        verifyIfExist(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExist(Long id) throws NotFoundPersonException {
        return personRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundPersonException(id));
    }
}
