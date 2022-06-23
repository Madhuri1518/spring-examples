package com.zemoso.spring_examples.mapper;

import com.zemoso.spring_examples.dto.StudentDTO;
import com.zemoso.spring_examples.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentDTO convertToDto(Student student){
        return new StudentDTO(student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }

    public Student convertToEntity(StudentDTO studentDTO){
        return new Student(studentDTO.getId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail());
    }

    public List<StudentDTO> convertToDtos(List<Student> studentList){
        return studentList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
