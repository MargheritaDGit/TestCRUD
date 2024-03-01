package com.example.TestCRUD;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles(value = "test")
public class StudentServiceTEST {
        @Autowired
        StudentService studentService;
        @Autowired
        StudentRepository studentRepository;
        @Test
        void studentIsWorking() throws Exception{
            Student student = new Student();
            student.setId(1L);
            student.setName("Michele");
            student.setSurname("Bianco");
            student.setWorking(true);

            Student studentFromDB = studentRepository.save(student);
            assertThat(studentFromDB).isNotNull();
            assertThat(studentFromDB.getId()).isNotNull();

            Student studentFromService = studentService.updateIsWorking(studentFromDB.getId(), true);
            assertThat(studentFromService).isNotNull();
            assertThat(studentFromService.getId()).isNotNull();
        }
    }

