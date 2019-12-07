/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Farrukh
 */
public class Patient {

    private String name;
    private String cnic;
    private String gender;
    private int age;
    private String disease;

    
    //Default constructor
    public Patient() {
        this.name = "";
        this.cnic = "";
        this.gender = "";
        this.age = 0;
        this.disease = "";

    }

    //parametrized constructor
    public Patient(String name, String cnic, String gender, int age, String disease) {
        this.name = name;
        this.cnic = cnic;
        this.gender = gender;
        this.age = age;
        this.disease = disease;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
