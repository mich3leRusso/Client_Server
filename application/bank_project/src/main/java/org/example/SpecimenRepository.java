package org.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SpecimenRepository extends CrudRepository<Contact,Long> {
    //returns null if the there is no contact
    Contact findBySurname(String surname) ;
}
