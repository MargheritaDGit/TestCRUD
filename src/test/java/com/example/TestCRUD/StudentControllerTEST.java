package com.example.TestCRUD;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class StudentControllerTEST {
    @Autowired
    Controller controller;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testController() {
        assertThat(controller).isNotNull();
    }

    public Student createStudent() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Margherita");
        student.setSurname("Deodato");
        student.setWorking(true);
        String studentJson = objectMapper.writeValueAsString(student); //dovrebbe trasformare oggetto student in una stringa
        MvcResult result = this.mockMvc.perform(post("/api/create").contentType(MediaType.APPLICATION_JSON)
                .content(studentJson)).andExpect(status().isOk()).andReturn();
        String studentJson1 = result.getResponse().getContentAsString();
        return objectMapper.readValue(studentJson1, Student.class);
    }

    @Test
    void testCreateStudent() throws Exception{
        Student student = createStudent();
        assertThat(student.getId()).isNotNull();
    }
}
