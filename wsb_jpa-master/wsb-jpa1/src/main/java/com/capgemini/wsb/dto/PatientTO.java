package com.capgemini.wsb.dto;

import javax.persistence.Column;
import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;
public class PatientTO implements Serializable {


    private Long id;

    private String firstName;

    private String lastName;

    private String telephoneNumber;


    private String email;

    private String patientNumber;

    private LocalDate dateOfBirth;

    private Double height_cm;

    public Double getHeight() {
        return height_cm;
    }

    public void setHeight(Double height) {
        this.height_cm = height;
    }


    private List<VisitTO> visitsPatientTOList;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<VisitTO> getVisitsPatientTOList() {
        return visitsPatientTOList;
    }

    public void setVisitsPatientTOList(List<VisitTO> visitsPatientTOList) {
        this.visitsPatientTOList = visitsPatientTOList;
    }


}