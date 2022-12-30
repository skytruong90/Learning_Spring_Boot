package com.example.gymMember.gymMember;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
//this is for hibernate
@Table
//this for table in database
public class GymMember {

    @Id
    @SequenceGenerator(
            name = "gymMember_sequence",
            sequenceName = "gymMember_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gymMember_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    @Transient
    private Integer suggestedCalories;
    private Double weight;


    public GymMember() {
    }

    public GymMember(Long id,
                     String name,
                     String email,
                     LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public GymMember(Long id,
                     String name,
                     String email,
                     LocalDate dob,
                     Double weight) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.weight = weight;
    }

    public GymMember(String name, String email, LocalDate dob, Double weight) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.weight = weight;
    }

    public GymMember(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getSuggestedCalories() {
        Double calories = (weight*15);
        Integer cv = calories.intValue();
        return cv;
    }

    public void setSuggestedCalories(Integer suggestedCalories) {
        this.suggestedCalories = suggestedCalories;
    }
}
