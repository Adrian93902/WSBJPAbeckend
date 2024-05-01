package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{

    @Override
    public List<PatientEntity> findByVisitDescription (String pDesc){
        return entityManager.createQuery("select patient from PatientEntity patient " +
                                            "join patient.visitsPatientList visits " +
                                            "where visits.description like :param1 ", PatientEntity.class )
                            .setParameter("param1",pDesc)
                            .getResultList();
    }
    @Override
    public List<PatientEntity> findByMinNumberOfVisits (long  pNumOfVisits)
    {
        return entityManager.createQuery(
                        "SELECT patient FROM PatientEntity patient " +
                                "JOIN patient.visitsPatientList visits " +
                                "GROUP BY patient " +
                                "HAVING COUNT(visits) >= :param1", PatientEntity.class)
                .setParameter("param1", pNumOfVisits)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByVisitDateRange (LocalDateTime pDateFrom, LocalDateTime pDateTo)
    {
        return entityManager.createQuery(
                        "SELECT DISTINCT patient FROM PatientEntity patient " +
                                "JOIN patient.visitsPatientList visits " +
                                "WHERE visits.time BETWEEN :dateFrom AND :dateTo", PatientEntity.class)
                .setParameter("dateFrom", pDateFrom)
                .setParameter("dateTo", pDateTo)
                .getResultList();

    }
    @Override
    public List<PatientEntity> findByDoctor (String pDoctorName)
    {

        return entityManager.createQuery(
                        "SELECT DISTINCT patient FROM PatientEntity patient " +
                                "JOIN patient.visitsPatientList visits " +
                                "WHERE visits.doctorEntity.firstName = :firstName " +
                                "AND visits.doctorEntity.lastName = :lastName", PatientEntity.class)
                .setParameter("firstName", pDoctorName.split(" ")[0])
                .setParameter("lastName", pDoctorName.split(" ")[1])
                .getResultList();
    }
    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery(
                        "SELECT DISTINCT patient FROM PatientEntity patient " +
                                "WHERE patient.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }
    @Override
    public List<PatientEntity> findByTreatmentType (TreatmentType pTreatmentType)
    {
        return entityManager.createQuery(
                        "SELECT DISTINCT patient FROM PatientEntity patient " +
                                "JOIN patient.visitsPatientList visits " +
                                "JOIN visits.medicalTreatmentEntityList treatment " +
                                "WHERE treatment.type = :treatmentType", PatientEntity.class)
                .setParameter("treatmentType", pTreatmentType)
                .getResultList();
    }
    @Override
    public long countVisitsOfPatientInTimeRange(String pPatName, LocalDateTime pDateFrom, LocalDateTime pDateTo)
    {
        return (long) entityManager.createQuery(
                        "SELECT COUNT(visits) FROM PatientEntity patient " +
                                "JOIN patient.visitsPatientList visits " +
                                "WHERE patient.firstName = :firstName " +
                                "AND patient.lastName = :lastName " +
                                "AND visits.time BETWEEN :dateFrom AND :dateTo")
                .setParameter("firstName", pPatName.split(" ")[0]) // Pobierz imię
                .setParameter("lastName", pPatName.split(" ")[1])  // Pobierz nazwisko
                .setParameter("dateFrom", pDateFrom)
                .setParameter("dateTo", pDateTo)
                .getSingleResult();
    }
}
