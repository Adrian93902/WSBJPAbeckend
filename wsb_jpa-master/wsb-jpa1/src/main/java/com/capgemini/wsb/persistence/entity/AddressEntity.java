package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", length = 19, nullable = false)
	private Long id;

	@Column(name = "city")
	private String city;

	@Column(name = "addressLine1")
	private String addressLine1;

	@Column(name = "addressLine2")
	private String addressLine2;

	@Column(name = "postalCode")
	private String postalCode;

	@OneToOne(mappedBy = "addressMap", cascade = CascadeType.ALL)
	private DoctorEntity doctorMap;

	@OneToOne(mappedBy = "addressMap", cascade = CascadeType.ALL)
	private PatientEntity patientMap;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setDoctor(DoctorEntity doctorMap) {
		this.doctorMap = doctorMap;
	}
	public DoctorEntity getDoctor() {
		return doctorMap;
	}


	public void setPatient(PatientEntity patientMap) {
		this.patientMap = patientMap;
	}

	public PatientEntity getPatient() {
		return patientMap;
	}



}
