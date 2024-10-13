package com.ProjectH2Fly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
public class Log {

    public Log(){}

    public Log(int id, String description, Date dateStamp) {
        this.id = id;
        this.description = description;
        this.dateStamp = dateStamp;
    }
    public Log(String description){
        this.description = description;
        this.dateStamp = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private Date dateStamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }
}
