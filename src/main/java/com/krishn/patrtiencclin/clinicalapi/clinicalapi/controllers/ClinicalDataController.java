package com.krishn.patrtiencclin.clinicalapi.clinicalapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishn.patrtiencclin.clinicalapi.clinicalapi.dto.ClinicalDataRequest;
import com.krishn.patrtiencclin.clinicalapi.clinicalapi.models.ClinicalData;
import com.krishn.patrtiencclin.clinicalapi.clinicalapi.models.Patient;
import com.krishn.patrtiencclin.clinicalapi.clinicalapi.repos.ClinicalDataRepository;
import com.krishn.patrtiencclin.clinicalapi.clinicalapi.repos.PatientRepository;

@RestController
@RequestMapping("/clinicaldata")
@CrossOrigin(origins = "*")
public class ClinicalDataController {

    @Autowired
    private ClinicalDataRepository clinicalDataRepository;
    
    @Autowired
    private PatientRepository patientRepository;

    // Create a new clinical data entry
    @PostMapping
    public ClinicalData createClinicalData(@RequestBody ClinicalData clinicalData) {
        return clinicalDataRepository.save(clinicalData);
    }

    // Get all clinical data entries
    @GetMapping
    public List<ClinicalData> getAllClinicalData() {
        return clinicalDataRepository.findAll();
    }

    // Get a clinical data entry by ID
    @GetMapping("/{id}")
    public Optional<ClinicalData> getClinicalDataById(@PathVariable Long id) {
        return clinicalDataRepository.findById(id);
    }

    // Update a clinical data entry
    @PutMapping("/{id}")
    public ClinicalData updateClinicalData(@PathVariable Long id, @RequestBody ClinicalData clinicalDataDetails) {
        Optional<ClinicalData> optionalClinicalData = clinicalDataRepository.findById(id);
        if (optionalClinicalData.isPresent()) {
            ClinicalData clinicalData = optionalClinicalData.get();
            clinicalData.setComponentName(clinicalDataDetails.getComponentName());
            clinicalData.setComponentValue(clinicalDataDetails.getComponentValue());
            clinicalData.setMeasuredDateTime(clinicalDataDetails.getMeasuredDateTime());
            return clinicalDataRepository.save(clinicalData);
        } else {
            throw new RuntimeException("ClinicalData not found with id " + id);
        }
    }

    // Delete a clinical data entry
    @DeleteMapping("/{id}")
    public void deleteClinicalData(@PathVariable Long id) {
        clinicalDataRepository.deleteById(id);
    }

    //method that recive patiend id, clinical data and save it to the database
    @PostMapping("/clinicals")
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
       Patient patient = patientRepository.findById(request.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setPatient(patient);
        return clinicalDataRepository.save(clinicalData);
    }
}