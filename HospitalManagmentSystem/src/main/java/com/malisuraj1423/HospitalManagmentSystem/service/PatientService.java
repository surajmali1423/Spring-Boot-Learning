package com.malisuraj1423.HospitalManagmentSystem.service;

import com.malisuraj1423.HospitalManagmentSystem.entity.Patient;
import com.malisuraj1423.HospitalManagmentSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {


       private  final PatientRepository patientRepository;

       @Transactional
    public Patient getPatientById(Long id) {
         Patient p1 = patientRepository.findById(id)
                     .orElseThrow(() -> new RuntimeException("Patient not found"));

        Patient p2 = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        p1.setName("Suraj Mali");

           Patient p3 = patientRepository.deleteByName("Amit Kumar");
//           System.out.println(p3);

        return p3;
    }
}
