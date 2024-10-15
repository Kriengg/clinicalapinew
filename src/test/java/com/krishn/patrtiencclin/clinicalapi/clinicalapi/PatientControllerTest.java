package com.krishn.patrtiencclin.clinicalapi.clinicalapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krishn.patrtiencclin.clinicalapi.clinicalapi.models.Patient;
import com.krishn.patrtiencclin.clinicalapi.clinicalapi.repos.PatientRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "/schema.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientRepository patientRepository;

    @Test
    public void testCreatePatient() throws Exception {
        String newPatientJson = "{\"name\":\"John Doe\",\"age\":30}";

        mockMvc.perform(post("/patientservices/patients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPatientJson))
                .andExpect(status().isCreated()); // Expecting 201 Created
    }

    @Test
    public void testGetAllPatients() throws Exception {
        mockMvc.perform(get("/patientservices/patients"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    String json = result.getResponse().getContentAsString();
                    List<Patient> patients = new ObjectMapper().readValue(json, new TypeReference<List<Patient>>() {});
                    // Add assertions to verify the patients list
                });
    }
}