package com.example.TestCRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createNewStudent(@RequestBody Student student) {
        return studentService.createNewStudent(student);
    }

    @GetMapping("/getList")
    public List<Student> studentList() {
        return studentService.studentList();
    }

    @GetMapping("/getStudent/{id}")
    public Student studentById(@PathVariable Long id) {
        return studentService.studentById(id);
    }

    @PatchMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @PatchMapping("/updateWork/{id}")
    public Student updateIsWorking(@PathVariable Long id, @RequestParam boolean isWorking) {
        return studentService.updateIsWorking(id, isWorking);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
