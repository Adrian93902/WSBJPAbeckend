package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "Doctor")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id", length = 19, nullable = false)
	private Long id;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Column(name = "telephoneNumber", nullable = false)
	private String telephoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "doctorNumber", nullable = false)
	private String doctorNumber;

	@Column(name = "specialization", nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;



	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private AddressEntity addressMap;
	@OneToMany(mappedBy = "doctorEntity", fetch = FetchType.LAZY)
	private List<VisitEntity> visitsDoctorList;


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

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public AddressEntity getAddress() {
		return addressMap;
	}

	public void setAddress(AddressEntity addressMap) {
		addressMap.setDoctor(this);
		this.addressMap = addressMap;
	}

	public List<VisitEntity> getVisitsDoctorList() {
		return visitsDoctorList;
	}

	public void setVisitsDoctorList(List<VisitEntity> visitsDoctorList) {
		this.visitsDoctorList = visitsDoctorList;
	}

}
