package dev.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class User {

    /*@Length(min = 5, message = "You have a problem in your fullname")*/
    @NotNull
    private String fullname;

    @NotNull
    @Past
    private LocalDate dob;

    private List<Quata> quata;
    public List<Quata> getquata() {
        return quata;
    }

    public void setquata(List<Quata> quata) {
        this.quata = quata;
    }


    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Incorrect email format")
    private String email;

    @NotNull
    @Size(min = 8)
    private int id;
    private Gender gender;
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public enum Gender {
        MALE, FEMALE, OTHER
    }
    public User() {
    }

    public User(String fullname, String email, int id,LocalDate dob) {
        this.fullname = fullname;
        this.email = email;
        this.id = id;
        this.dob=dob;


    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
