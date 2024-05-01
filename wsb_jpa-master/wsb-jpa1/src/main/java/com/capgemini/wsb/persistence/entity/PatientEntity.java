package com.capgemini.wsb.persistence.entity;

import java.time.LocalDate;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Patient")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id", length = 19, nullable = false)
	private Long id;


	@Column(name = "firstName", nullable = false)
	private String firstName;


	@Column(name = "lastName", nullable = false)
	private String lastName;


	@Column(name = "telephoneNumber", nullable = false)
	private String telephoneNumber;


	@Column(name = "email")
	private String email;

	@Column(name = "patientNumber", nullable = false)
	private String patientNumber;

	@Column(name = "dateOfBirth", nullable = false)
	private LocalDate dateOfBirth;

	@OneToMany(mappedBy = "patientEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<VisitEntity> visitsPatientList;




	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private AddressEntity addressMap;

	@Column(name = "height_cm")
	private Double height_cm;



	/*@OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
	private List<VisitEntity> visitEntityList;*/


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

	public  List<VisitEntity> getVisitsPatientList() {
		return visitsPatientList;
	}

	public void setVisitsPatientList(List<VisitEntity> visitsPatientList) {
		this.visitsPatientList = visitsPatientList;
	}
	public AddressEntity getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(AddressEntity addressMap) {
		this.addressMap = addressMap;
	}

	public Double getHeight_cm() {
		return height_cm;
	}

	public void setHeight_cm(Double height_cm) {
		this.height_cm = height_cm;
	}


}
