package dev.domain;


import javax.validation.constraints.*;
import java.time.LocalDate;

public class User {

    /*@Length(min = 5, message = "You have a problem in your fullname")*/
    @NotNull
    private String fullname;

    @NotNull
    @Age
    private LocalDate dob;
    @NotNull
    private String Country;
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
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Incorrect email format")
    private String email;

    @NotNull
    @Min(1)
    @Max(9999)
    private int id;

    @NotNull
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

    public User(String fullname, String email, int id,LocalDate dob,Gender gender,String quataValues, String Country) {
        this.fullname = fullname;
        this.email = email;
        this.id = id;
        this.dob=dob;
        this.quataValues = quataValues;
        this.Country=Country;
        this.gender=gender;



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
    public void setCountry(String Country) {
        this.Country = Country;
    }
    public String getCountry() {
        return Country;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
