package com.Surajmali._3.RESTAPILearning.controller;


import com.Surajmali._3.RESTAPILearning.dto.StudentDto;
import com.Surajmali._3.RESTAPILearning.dto.StudentImpDto;
import com.Surajmali._3.RESTAPILearning.service.StudentServise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final  StudentServise studentServise;

    StudentController(StudentServise studentServise){
        this.studentServise = studentServise;
    }


    @GetMapping
    public List<StudentDto> getStudent() {
        return studentServise.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return studentServise.getStudentById(id);
    }

    @PostMapping("")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentImpDto studentImpDto){
            return ResponseEntity.status(HttpStatus.CREATED).body(studentServise.creatStudent(studentImpDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
            studentServise.deleteStudent(id);
            return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id , @RequestBody StudentImpDto studentImpDto){
                   return ResponseEntity.ok(studentServise.updateStudent(id , studentImpDto));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id,
                                                           @RequestBody Map<String , Objects>upadates){
         return ResponseEntity.ok(studentServise.updatePartialStudent(id , upadates));
    }
}
