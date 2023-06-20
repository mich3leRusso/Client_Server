package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContactService {

    private final SpecimenRepository spes;

    @Autowired
    public ContactService( SpecimenRepository spes) {
        this.spes = spes;

    }

    public List<Contact> retrieveContacts() {
        return (List<Contact>) spes.findAll();
    }

    public Contact getContactBySurname(String surname) {
        return spes.findBySurname(surname);
    }

    public Contact createContact(Contact contact) {
        if(!spes.existsById(contact.getId())){
            //element dont exist
            return spes.save(contact);
        }
        return null;
    }

    public boolean deleteContact(Long id) {
        if(spes.existsById(id)){
            spes.deleteById(id);
            return true;
        }
        else{
            throw new IllegalArgumentException("this element doesnt exist");
        }
    }

    public Contact updateContact(Long id, Contact updatedContact) {
        Contact contact;
        if(spes.existsById(id)){
            Optional<Contact> currentContact=spes.findById(id);
            contact = currentContact.orElse(null);
            contact.setPhoneNumber(updatedContact.getPhoneNumber());
            contact.setName(updatedContact.getName());
            contact.setSurname(updatedContact.getSurname());
        }else{
            throw new IllegalArgumentException("you are trying to update a contact that dont exist");
        }
        return contact;
    }

}
