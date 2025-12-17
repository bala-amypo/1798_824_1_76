package com.example.demo.service;

import com.example.demo.entity.PersonProfile;
import java.util.List;

public interface PersonProfileService {
    PersonProfile createPerson(PersonProfile p);
    PersonProfile getPersonById(Long id);
    List<PersonProfile> getAllPersons();
    PersonProfile findByReferenceId(String ref);
    PersonProfile updateRelationshipDeclared(Long id, boolean declared);
}