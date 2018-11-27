package com.grind.uni_progect;

import com.grind.uni_progect.entity.Teacher;
import com.grind.uni_progect.entity.UniGroup;
import com.grind.uni_progect.repositories.GroupRepos;
import com.grind.uni_progect.repositories.TeacherRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupRepos groupRepos;

    @Autowired
    private TeacherRepos teacherRepos;

    @GetMapping()
    public String getAll(Map<String, Object> model) {
        model.put("groups", groupRepos.findAll());
        model.put("teachers", teacherRepos.findAll());
        return "groups";
    }

    @PostMapping
    public String addGroupPost(@RequestParam String name,
                               @RequestParam Teacher teacher,
                               Map<String, Object> model) {
        UniGroup group = new UniGroup();
        group.setName(name);
        if (teacher.getName() != null) {
            group.setTeacher(teacher);
        }
        groupRepos.save(group);
        model.put("groups", groupRepos.findAll());
        model.put("teachers", teacherRepos.findAll());
        return "groups";
    }

    @GetMapping("/get")
    public @ResponseBody
    List<UniGroup> getAllByTeacher(@RequestParam(name = "teacher") String teacherName) {
        List<UniGroup> groupList = groupRepos.findUniGroupsByTeacherName(teacherName);
        return groupList;
    }
}
