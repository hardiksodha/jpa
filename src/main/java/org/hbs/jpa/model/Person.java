package org.hbs.jpa.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name="person_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private int age;
    private String city;
    private String gender;
    private String occupation;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", nullable=false)
    Set<ContactDetail> contactDetailList;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public Set<ContactDetail> getContactDetailList() {
        return contactDetailList;
    }

    public void setContactDetailList(Set<ContactDetail> contactDetailList) {
        this.contactDetailList = contactDetailList;
    }
}