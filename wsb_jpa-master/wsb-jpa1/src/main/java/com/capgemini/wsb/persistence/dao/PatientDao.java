package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
public interface PatientDao extends Dao<PatientEntity, Long>
{
    List<PatientEntity> findByVisitDescription (String pDesc);
    List<PatientEntity> findByMinNumberOfVisits (long  pNumOfVisits);
    List<PatientEntity> findByVisitDateRange (LocalDateTime pDateFrom, LocalDateTime pDateTo);
    List<PatientEntity> findByDoctor (String pDoctorName);
    List<PatientEntity> findByLastName(String lastName);
    List<PatientEntity> findByTreatmentType (TreatmentType pTreatmentType);
    long countVisitsOfPatientInTimeRange(String pPatName, LocalDateTime pDateFrom, LocalDateTime pDateTo);


}
