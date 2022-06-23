package com.zemoso.spring_examples.services;

import com.zemoso.spring_examples.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    public List<StudentDTO> getStudents();

    public void saveStudent(StudentDTO studentDTO);

    public StudentDTO getStudent(int id);

    public void deleteStudent(int id);

}
