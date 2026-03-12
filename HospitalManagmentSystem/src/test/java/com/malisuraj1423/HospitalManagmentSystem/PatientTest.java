package com.malisuraj1423.HospitalManagmentSystem;


import com.malisuraj1423.HospitalManagmentSystem.entity.Patient;
import com.malisuraj1423.HospitalManagmentSystem.repository.PatientRepository;
import com.malisuraj1423.HospitalManagmentSystem.service.PatientService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

     @Autowired
     private  PatientRepository patientRepository;

     @Autowired
     private PatientService patientService;

     @Test
     public void SetPatient(){
           Patient p1 = patientService.getPatientById(119L);
          System.out.println(p1);
     }


     @Test
     public void getPatient(){
        List<Patient>  patientList =  patientRepository.findAll();
        System.out.println(patientList);
     }

     @Test
    public void getPatientByID(){
         Patient p1 = patientService.getPatientById(119L);
         System.out.println(p1);
     }

    @Transactional
     @Test
     public void FindMethods(){
           // findByName
           Patient p1 = patientRepository.findByName("Amit Kumar");
           System.out.println(p1);

           // findByEmail
           Patient p2 = patientRepository.findByEmail("rahul.sharma@example.com");
           System.out.println(p2);


           Patient p3 = patientRepository.findByGender("female");
           System.out.println(p3);

           Patient p4 = patientRepository.deleteByName("Amit Kumar");
           System.out.println(p4);
     }

     @Test
     public void LogicalMethods(){
            // And
            Patient p1 = patientRepository.findByNameAndEmail("Amit Kumar" , "amit.kumar@example.com");
            System.out.println(p1);

            //  Or
            Patient p2 = patientRepository.findByNameOrEmail("Amit Kumar" , "aas@email.com");
            System.out.println(p2);

            //Not
            List<Patient> p3 = patientRepository.findByGenderNot("Male");
            p3.forEach(System.out::println);
     }

     @Test
     public void ComparisonMethods(){
           // Is
           Patient p1 = patientRepository.findByNameIs("Amit Kumar");
           System.out.println(p1);

           // Equal
          Patient p2 = patientRepository.findByEmailEquals("amit.kumar@example.com");
          System.out.println(p2);

          // GreaterThan
         List <Patient> p3 = patientRepository.findByIdGreaterThan(120L);
         System.out.println(p3);

         // LessThan
         List<Patient> p4 = patientRepository.findByIdLessThan(121L);
         System.out.println(p4);

         //GreaterThanEqual
         List <Patient> p5 = patientRepository.findByIdGreaterThanEqual(121L);
         System.out.println(p5);

         // LessThanEqual
         List<Patient> p6 = patientRepository.findByIdLessThanEqual(121L);
         System.out.println(p6);

         // Between
         List<Patient>p7 = patientRepository.findByIdBetween(120L , 122L);
         System.out.println(p7);


     }

     @Test
     public void LikeMethos(){
           // Like
           Patient p1 = patientRepository.findByNameLike("Amit Kumar");
           System.out.println(p1);

           //NotLike
           List<Patient> p2 = patientRepository.findByNameNotLike("Amit Kumar");
           System.out.println(p2);

           // StartWith
           List<Patient> p3 = patientRepository.findByNameStartingWith('R');
           System.out.println(p3);

           //EndingWith
           List<Patient> p4 = patientRepository.findByNameEndingWith('r');
           System.out.println(p4);

           //Containing
           Patient p5 = patientRepository.findByNameContaining("Rahul Sharma");
           System.out.println(p5);
     }

     @Test
    public void SortMethods(){
          List<Patient> p1 = patientRepository.findByOrderByNameAsc();
          System.out.println(p1);

          List<Patient>p2 = patientRepository.findByOrderByNameDesc();
          System.out.println(p2);
     }

     @Test
    public void NullCheckMethods() {
         // IsNull
        List<Patient> p1 = patientRepository.findByCreatedAtIsNull();
        System.out.println(p1);

        //IsNotNull
        List<Patient> p2 = patientRepository.findByCreatedAtIsNotNull();
        System.out.println(p2);
    }
}
