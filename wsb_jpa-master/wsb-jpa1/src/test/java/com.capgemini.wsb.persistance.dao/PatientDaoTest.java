package com.capgemini.wsb.persistance.dao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.impl.PatientDaoImpl;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    @Transactional
    public void testFindByVisitDescription() {
        // given
        String visitDescription = "Badanie kontrolne";

        // when
        List<PatientEntity> foundPatients = patientDao.findByVisitDescription(visitDescription);
        // then

        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients).isNotEmpty();
        assertEquals(foundPatients.get(0).getFirstName(), "Anna");
        assertEquals(foundPatients.get(0).getLastName(), "Nowak");
        assertEquals(foundPatients.get(0).getTelephoneNumber(), "987654321");

    }

    @Test
    @Transactional
    public void testFindByMinNumberOfVisits() {
        // given
        long minNumberOfVisits = 2;

        // when
        List<PatientEntity> foundPatients = patientDao.findByMinNumberOfVisits(minNumberOfVisits);
        // then
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients).isNotEmpty();
        assertEquals(foundPatients.size(),6);

    }

    @Test
    @Transactional
    public void testFindByVisitDateRange() {
        // given
        LocalDateTime dateFrom = LocalDateTime.now().minusMonths(1);
        LocalDateTime dateTo = LocalDateTime.now();


        // when
        List<PatientEntity> foundPatients = patientDao.findByVisitDateRange(dateFrom, dateTo);

        // then
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients).isNotEmpty();
        assertEquals(foundPatients.size(), 6);

        // Assuming the first patient's details are as follows:
        PatientEntity firstPatient = foundPatients.get(0);
        assertEquals(firstPatient.getFirstName(), "Monika");
        assertEquals(firstPatient.getLastName(), "Lis");
        assertEquals(firstPatient.getTelephoneNumber(), "147258369");
        assertEquals(firstPatient.getEmail(), "monika.lis@example.com");
        assertEquals(firstPatient.getPatientNumber(), "PAT789");
        assertEquals(172.0, firstPatient.getHeight_cm(), 0.001);
        assertEquals(firstPatient.getDateOfBirth(), LocalDate.of(1980, 12, 30));

    }

    @Test
    @Transactional
    public void testFindByDoctor() {
        // given
        String doctorFullName = "Jan Kowalski";

        // when
        List<PatientEntity> foundPatients = patientDao.findByDoctor(doctorFullName);

        // then
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients).isNotEmpty();

        if (foundPatients.size() > 0) {
            PatientEntity firstPatient = foundPatients.get(0);
            assertEquals(firstPatient.getFirstName(), "Anna");
            assertEquals(firstPatient.getLastName(), "Nowak");
            assertEquals(firstPatient.getTelephoneNumber(), "987654321");
            assertEquals(firstPatient.getEmail(), "anna.nowak@example.com");
            assertEquals(firstPatient.getPatientNumber(), "PAT123");
            assertEquals(165.0, firstPatient.getHeight_cm(), 0.001);
            assertEquals(firstPatient.getDateOfBirth(), LocalDate.of(2000, 1, 1));
        } else {
            fail("Nie znaleziono pacjentów dla podanego lekarza.");
        }
    }

    @Test
    @Transactional
    public void testFindByTreatmentType() {
        // given
        TreatmentType treatmentType = TreatmentType.USG;

        // when
        List<PatientEntity> foundPatients = patientDao.findByTreatmentType(treatmentType);
        // then
        if (foundPatients.size() > 0) {
            PatientEntity firstPatient = foundPatients.get(0);
            assertEquals(firstPatient.getFirstName(), "Marek");
            assertEquals(firstPatient.getLastName(), "Szymański");
            assertEquals(firstPatient.getTelephoneNumber(), "852963147");
            assertEquals(firstPatient.getEmail(), "marek.szymanski@example.com");
            assertEquals(firstPatient.getPatientNumber(), "PAT1234");
            assertEquals(190.0, firstPatient.getHeight_cm(), 0.001);
            assertEquals(firstPatient.getDateOfBirth(), LocalDate.of(1976, 9,20));
        } else {
            fail("Nie znaleziono pacjentów dla podanego typu procedury medycznej.");
        }
    }

    @Test
    @Transactional
    public void testCountVisitsOfPatientInTimeRange() {
        // given
        String patientName = "Anna Nowak";
        LocalDateTime dateFrom = LocalDateTime.now().minusMonths(1);
        LocalDateTime dateTo = LocalDateTime.now();
        // assuming we have a patient with visits within the given date range
        // add logic to create such patient and visits
        // when
        long visitCount = patientDao.countVisitsOfPatientInTimeRange(patientName, dateFrom, dateTo);
        // then
        assertThat(visitCount).isEqualTo(2); // Ensure non-negative count
        // Add more assertions as needed
    }
}
