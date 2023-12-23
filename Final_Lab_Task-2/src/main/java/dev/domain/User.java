package dev.domain;

import javax.persistence.Table;

import org.hibernate.annotations.Entity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
@Entity
@Table(name = "users")
public class User {

    /*@Length(min = 5, message = "You have a problem in your fullname")*/
    @NotNull
    @Column(name = "FullName")
    private String fullname;

    @NotNull
    @Age
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "DOB")
    private LocalDate dob;
    @NotNull
    @Column(name = "Country")

    private String country;
    @Column(name = "Quata")

    private String quataValues;
    public String getQuataValues() {
        return quataValues;
    }

    public void setQuataValues(String quataValues) {
        this.quataValues = quataValues;
    }




    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



    @NotNull
    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Incorrect email format")
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender g) {
        this.gender = g;
    }
    public enum Gender {
        MALE, FEMALE, OTHER
    }
    public User() {
    }

    public User(String fullname, String email, int id,LocalDate dob,Gender g,String quataValues, String country) {
        this.fullname = fullname;
        this.email = email;
        this.id = id;
        this.dob=dob;
        this.quataValues = quataValues;
        this.country=country;
        this.gender=g;



    }
  /*  public User(String fullname, String email, int id,LocalDate dob, Gender gender, String Country) {
        this.fullname = fullname;
        this.email = email;
        this.id = id;
        this.dob=dob;
        this.gender=gender;
        this.quataValues = quataValues;
        this.Country=Country;



    }*/


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
