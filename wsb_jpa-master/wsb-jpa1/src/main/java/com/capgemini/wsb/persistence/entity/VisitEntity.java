package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Visit")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visit_id", length = 19, nullable = false)
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "time", nullable = false)
	private LocalDateTime time;


	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctorEntity;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patientEntity;



	@OneToMany(mappedBy = "visitEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MedicalTreatmentEntity> medicalTreatmentEntityList;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}



	public void setDoctorEntity(DoctorEntity doctorEntity) {

		this.doctorEntity = doctorEntity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}
	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public DoctorEntity getDoctorEntity() {
		return doctorEntity;
	}
	public List<MedicalTreatmentEntity> getMedicalTreatmentEntityList() {
		return medicalTreatmentEntityList;
	}

	public void addMedicalTreatmentEntity(MedicalTreatmentEntity medicalTreatmentEntity) {
		medicalTreatmentEntityList.add(medicalTreatmentEntity);
			}
}
