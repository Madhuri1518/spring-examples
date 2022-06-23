package com.zemoso.spring_examples;

import com.zemoso.spring_examples.config.SportConfig;
import com.zemoso.spring_examples.dto.StudentDTO;
import com.zemoso.spring_examples.services.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateExamplesApp {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(SportConfig.class);
        StudentService studentService = context2.getBean(StudentService.class);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setEmail("d@d23.co");
        studentDTO.setFirstName("fd2s");
        studentDTO.setLastName("df2");
        // save
        studentService.saveStudent(studentDTO);

        // get all students
        System.out.println("get students "+studentService.getStudents());

        int id = 6;
        // get students by id
        System.out.println("first student "+studentService.getStudent(id));

        // delete student
        studentService.deleteStudent(id);

        // get all students
        System.out.println("after delete, students "+studentService.getStudents());

        context2.close();
    }
}
