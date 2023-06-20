package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/giveMeContacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.retrieveContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @RequestMapping(value = "/getContact/{surname}",method = GET)
    public ResponseEntity<Contact> getContactBySurname(@PathVariable("surname") String surname) {

        return new ResponseEntity<>(contactService.getContactBySurname(surname),HttpStatus.OK);
    }
    @RequestMapping(value = "value=/save_element/{id}/{nome}/{Surname}/{Telefono}",method = GET)
    public boolean updateContact(@PathVariable("id") Long id,@PathVariable("nome") String nome,@PathVariable("Surname") String surname,@PathVariable("Telefono") String telefono){
        Contact updatedContact=new Contact(nome,surname,telefono,id);
        if(contactService.updateContact(id, updatedContact)!=null)
            return true;
        return false;
    }
    @RequestMapping(value = "/remove_element/{id}",method = GET)
    public boolean deleteContact(@PathVariable("id") Long id){
        return contactService.deleteContact(id);
    }

    @RequestMapping (value = "/createContact/{nome}/{Surname}/{Telefono}",method = GET)
    @ResponseBody
    public String createContact(@PathVariable("nome") String nome,@PathVariable("Surname") String surname,@PathVariable("Telefono") String telefono) {
        Long id= 25345457L;
        Contact contact=new Contact(nome,surname,telefono,id);
        Contact createdContact = contactService.createContact(contact);
        return "contact created ";
    }
}