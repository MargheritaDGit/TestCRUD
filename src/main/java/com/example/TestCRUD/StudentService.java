package com.example.TestCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student createNewStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> studentList() {
        return studentRepository.findAll();
    }

    public Student studentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student studentNew) {
        Student getStudentById = studentRepository.findById(id).orElse(null); //sto creando unom studente e sto cercando se esiste studente con quest id
        if (getStudentById != null) {
            getStudentById.setId(studentNew.getId());
            return studentRepository.save(getStudentById);
        }
        return null;
    }

    public Student updateIsWorking(Long id, boolean isWorking) {
        Student getStudentById = studentRepository.findById(id).orElse(null);
        if ((getStudentById == null)) return null;
        getStudentById.setWorking(isWorking);
        return studentRepository.save(getStudentById);
    }

    public void deleteStudent (Long id){
        studentRepository.deleteById(id);
    }
}
