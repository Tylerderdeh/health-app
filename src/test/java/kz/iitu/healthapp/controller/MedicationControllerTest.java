package kz.iitu.healthapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.healthapp.entity.Medication;
import kz.iitu.healthapp.service.MedicationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.xmlunit.util.Mapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@DisplayName("Модульные тесты MedicationController")
@AutoConfigureMockMvc
class MedicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    MedicationService medicationService;

    @InjectMocks
    MedicationController medicationController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getMedicationById() {
    }

    @Test
    void getAllMedications() {
    }

    @Test
    @DisplayName("createMedication создаст новое лекарство и вернет тело в ResponseBody со статусом CREATED")
    void createMedication_RequestIsValid_ReturnsResponseBodyWithCreatedMedication() {
        var medication = new Medication();

        this.medicationController.createMedication(medication);

    }

    @Test
    void updateMedication() {
    }

    @Test
    void deleteMedication() {
    }
}