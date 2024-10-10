package com.krishn.patrtiencclin.clinicalapi.clinicalapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishn.patrtiencclin.clinicalapi.clinicalapi.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Additional query methods (if needed) can be defined here
}