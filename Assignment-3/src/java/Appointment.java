/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Farrukh
 */
public class Appointment {
    private String patient_name;
    private String doctor_name;
    private String disease;
    private String scheduledDay;

    
    //Copy constructor
    public Appointment(String patient_name, String doctor_name, String disease, String scheduledDay) {
        this.patient_name = patient_name;
        this.doctor_name = doctor_name;
        this.disease = disease;
        this.scheduledDay = scheduledDay;
    }
    
    //Default constructor
    public Appointment()
    {
        this.patient_name = "";
        this.doctor_name = "";
        this.disease = "";
        this.scheduledDay = "";
    }
    
    
    //Getters and Setters

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getScheduledDay() {
        return scheduledDay;
    }

    public void setScheduledDay(String scheduledDay) {
        this.scheduledDay = scheduledDay;
    }
   
}
