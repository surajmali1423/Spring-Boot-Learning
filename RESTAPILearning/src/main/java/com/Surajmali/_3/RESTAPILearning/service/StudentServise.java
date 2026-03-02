package com.Surajmali._3.RESTAPILearning.service;

import com.Surajmali._3.RESTAPILearning.dto.StudentDto;
import com.Surajmali._3.RESTAPILearning.dto.StudentImpDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface StudentServise {

    List<StudentDto>getAllStudent();

   ResponseEntity<StudentDto> getStudentById(Long id);

    StudentDto creatStudent(StudentImpDto studentImpDto);

    void deleteStudent(Long id);

    StudentDto updateStudent(Long id, StudentImpDto studentImpDto);

    StudentDto updatePartialStudent(Long id, Map<String, Objects> upadates);
}
