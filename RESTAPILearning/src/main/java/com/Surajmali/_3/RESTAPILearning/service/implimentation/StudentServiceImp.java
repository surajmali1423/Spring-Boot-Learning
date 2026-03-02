package com.Surajmali._3.RESTAPILearning.service.implimentation;


import com.Surajmali._3.RESTAPILearning.dto.StudentDto;
import com.Surajmali._3.RESTAPILearning.dto.StudentImpDto;
import com.Surajmali._3.RESTAPILearning.entity.Student;
import com.Surajmali._3.RESTAPILearning.repository.StudentRepository;
import com.Surajmali._3.RESTAPILearning.service.StudentServise;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentServise {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {

        return studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public ResponseEntity<StudentDto> getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id : " + id)
                );
        StudentDto  studentdto = modelMapper.map(student , StudentDto.class);
        return ResponseEntity.ok(studentdto);
    }

    @Override
    public StudentDto creatStudent(StudentImpDto studentImpDto) {
             Student student = modelMapper.map(studentImpDto , Student.class);
             Student Student1 = studentRepository.save(student);
             return   modelMapper.map(Student1 , StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
              throw new IllegalArgumentException("Student does not exists by id : "+id);
        }

        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentImpDto studentImpDto) {
            Student student = studentRepository.findById(id).orElseThrow(
                    () ->
                            new IllegalArgumentException("Student Id Not Found id : "+id)
            );

             modelMapper.map(studentImpDto , student);
             student = studentRepository.save(student);

             return modelMapper.map(student , StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Objects> upadates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Student Not Found Id : " + id)
                );

        upadates.forEach((field, value) -> {
            switch (field) {

                case "name":
                    student.setName(String.valueOf(value));
                    break;

                case "email":
                    student.setEmail( String.valueOf(value));
                    break;

                default:
                    throw new IllegalArgumentException("Unknown field: " + field);
            }
        });

        // Save updated entity
        Student updatedStudent = studentRepository.save(student);

        return modelMapper.map(updatedStudent , StudentDto.class);
    }

}