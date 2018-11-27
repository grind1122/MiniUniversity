package com.grind.uni_progect;

import com.grind.uni_progect.entity.Student;
import com.grind.uni_progect.repositories.StudRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/students")
public class AppController {

    @Autowired
    private StudRepos repos;

    @GetMapping("/getAll")
    public @ResponseBody List<Student> getAll(){
        return (List<Student>) repos.findAll();
    }

    @GetMapping("/add")
    public @ResponseBody List<Student> addStudentGet(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        repos.save(student);
        return Collections.singletonList(student);
    }

    @PostMapping
    public String addStudentPost(@RequestParam String name,
                                 @RequestParam int age,

                                 Map<String, Object> model){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        repos.save(student);
        Iterable<Student> list = repos.findAll();
        model.put("students", list);
        return "main";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Student> list = repos.findAll();
        model.put("students", list);
        return "main";
    }

}
