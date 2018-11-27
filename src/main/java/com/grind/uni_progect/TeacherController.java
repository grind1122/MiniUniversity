package com.grind.uni_progect;

import com.grind.uni_progect.entity.Teacher;
import com.grind.uni_progect.repositories.GroupRepos;
import com.grind.uni_progect.repositories.StudRepos;
import com.grind.uni_progect.repositories.TeacherRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepos teacherRepos;

    @Autowired
    private GroupRepos groupRepos;

    @Autowired
    private StudRepos studRepos;

    @GetMapping
    public String getAll(Map<String, Object> model){
        model.put("teachers", teacherRepos.findAll());
        return "teachers";
    }

    @PostMapping
    public String addGroupPost(@RequestParam String name,
                               Map<String, Object> model){
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacherRepos.save(teacher);
        model.put("teachers", teacherRepos.findAll());
        return "teachers";
    }


}
