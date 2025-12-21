package com.example.demo.service;

import com.example.demo.entity.PersonProfile;
import java.util.List;

public interface PersonProfileService {
    PersonProfile create(PersonProfile p);
    PersonProfile getById(Long id);
    List<PersonProfile> getAll();
    PersonProfile updateRelationshipDeclared(Long id, Boolean declared);
    PersonProfile findByReferenceId(String referenceId);
}
    