package com.example.elinicproject;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Time;
import java.time.LocalDate;

public class visitData {

    public int getVisitID() {
        return visitID;
    }
    public void setVisitID(int dateID) {
        this.visitID = visitID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getVisitNote() {
        return visitNote;
    }
    public void setVisitNote(String visitNote) {
        this.visitNote = visitNote;
    }

    private int visitID;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private LocalDate date;
    private String visitNote;


}
