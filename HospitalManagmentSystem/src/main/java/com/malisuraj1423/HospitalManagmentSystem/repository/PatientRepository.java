package com.malisuraj1423.HospitalManagmentSystem.repository;

import com.malisuraj1423.HospitalManagmentSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient , Long> {
    Patient findByName(String name);
    Patient findByEmail(String mail);

    Patient findByBirthDate(String date);

    Patient findByGender(String male);

    Patient findByNameAndEmail(String amitKumar, String mail);

    Patient findByNameOrEmail(String amitKumar, String mail);

   List<Patient> findByGenderNot(String male);

    Patient findByNameIs(String amitKumar);

    Patient findByEmailEquals(String email);

    List<Patient> findByIdGreaterThan(long l);

    List<Patient> findByIdLessThan(long l);

    List<Patient> findByIdGreaterThanEqual(long l);

    List<Patient> findByIdLessThanEqual(long l);

    List<Patient> findByIdBetween(long l, long l1);

    Patient findByNameLike(String amitKumar);

    List<Patient> findByNameNotLike(String amitKumar);

    List<Patient> findByNameStartingWith(char a);

    List<Patient> findByNameEndingWith(char r);

    Patient findByNameContaining(String rahulSharma);

    List<Patient> findByOrderByNameAsc();

    List<Patient> findByOrderByNameDesc();

    List<Patient> findByCreatedAtIsNull();

    List<Patient> findByCreatedAtIsNotNull();

    Patient deleteByName(String amitKumar);
}
