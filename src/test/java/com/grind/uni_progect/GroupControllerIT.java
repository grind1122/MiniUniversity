package com.grind.uni_progect;

import com.grind.uni_progect.entity.Student;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupControllerIT {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testing() throws Exception{

            ResponseEntity<List<Student>> responseEntity = restTemplate.exchange("http://localhost:8080/students/getAll", HttpMethod.GET,
                    null, new ParameterizedTypeReference<List<Student>>() {
                    });
            List<Student> list = responseEntity.getBody();

//        validate
            assertThat(list.size(), CoreMatchers.is(5));
            List<String> names = new ArrayList<>();
            for (Student student :list){
                names.add(student.getName());
            }
            assertThat(names, containsInAnyOrder("masha","Lolo", "toto", "cucu", "robin")); // This params are names of student in your database

    }
}