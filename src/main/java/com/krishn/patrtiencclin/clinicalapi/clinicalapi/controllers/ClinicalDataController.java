package com.krishn.patrtiencclin.clinicalapi.clinicalapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishn.patrtiencclin.clinicalapi.clinicalapi.models.ClinicalData;
import com.krishn.patrtiencclin.clinicalapi.clinicalapi.repos.ClinicalDataRepository;

@RestController
@RequestMapping("/clinicaldata")
public class ClinicalDataController {

    @Autowired
    private ClinicalDataRepository clinicalDataRepository;

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
}