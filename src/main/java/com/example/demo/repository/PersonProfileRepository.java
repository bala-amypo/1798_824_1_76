package com.example.demo.repository;

import com.example.demo.model.PersonProfile;
import java.util.List;
import java.util.Optional;

public interface PersonProfileRepository {

    Optional<PersonProfile> findById(Long id);

    Optional<PersonProfile> findByEmail(String email);

    Optional<PersonProfile> findByReferenceId(String referenceId);

    List<PersonProfile> findAll();

    PersonProfile save(PersonProfile person);
}
