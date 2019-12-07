/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Farrukh
 */
class Doctor {

    private String name;
    private int ID;
    private String specialization;
    private String visiting_days;

    //Default constructor
    public Doctor() {
        this.name = "";
        this.ID = 0;
        this.specialization = "";
        this.visiting_days = "";
    }

    //Copy constructor
    public Doctor(String name, int ID, String specialization, String visiting_days) {
        this.name = name;
        this.ID = ID;
        this.specialization = specialization;
        this.visiting_days = visiting_days;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getVisiting_days() {
        return visiting_days;
    }

    public void setVisiting_days(String visiting_days) {
        this.visiting_days = visiting_days;
    }
}
