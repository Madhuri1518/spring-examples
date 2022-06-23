package com.zemoso.spring_examples.services;

import com.zemoso.spring_examples.dao.StudentDAO;
import com.zemoso.spring_examples.dto.StudentDTO;
import com.zemoso.spring_examples.entity.Student;
import com.zemoso.spring_examples.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> studentList = studentDAO.getStudents();
        return studentMapper.convertToDtos(studentList);
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = studentMapper.convertToEntity(studentDTO);
        studentDAO.saveStudent(student);
    }

    @Override
    public StudentDTO getStudent(int id) {
        Student student = studentDAO.getStudent(id);
        return studentMapper.convertToDto(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
