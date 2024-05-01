package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientDao patientDao;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Test
    void testFindById() {
        // Arrange
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);
        patientEntity.setFirstName("John");
        patientEntity.setLastName("Doe");
        patientEntity.setDateOfBirth(LocalDate.of(1980, 1, 1));

        Mockito.when(patientDao.findOne(patientId)).thenReturn(patientEntity);

        // Act
        PatientTO patientTO = patientService.findById(patientId);

        // Assert
        Assertions.assertNotNull(patientTO);
        Assertions.assertEquals(patientId, patientTO.getId());
        Assertions.assertEquals("John", patientTO.getFirstName());
        Assertions.assertEquals("Doe", patientTO.getLastName());
        Assertions.assertEquals(LocalDate.of(1980, 1, 1), patientTO.getDateOfBirth());
    }

    @Test
    void testDeleteById() {
        // Arrange
        Long patientId = 1L;

        // Act
        patientService.deleteById(patientId);

        // Assert
        Mockito.verify(patientDao, Mockito.times(1)).delete(patientId);
        Mockito.verifyNoMoreInteractions(patientDao);
    }
}