package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;

    // Constructors, getters, setters
    public Contact(String n, String s, String phone,Long id){
        name=n;
        surname=s;
        phoneNumber=phone;
        this.id=id;
    }

    public Contact() {

    }
    public Long getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setSurname(String sur){
        surname=sur;
    }
    public void setPhoneNumber(String phone){
        phoneNumber=phone;
    }
}
