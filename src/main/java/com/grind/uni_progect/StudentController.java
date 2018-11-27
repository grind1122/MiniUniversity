package com.grind.uni_progect;

import com.grind.uni_progect.entity.Student;
import com.grind.uni_progect.entity.UniGroup;
import com.grind.uni_progect.repositories.GroupRepos;
import com.grind.uni_progect.repositories.StudRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudRepos studRepos;

    @Autowired
    private GroupRepos groupRepos;

    @GetMapping("/getAll")
    public @ResponseBody List<Student> getAll(){
        return (List<Student>) studRepos.findAll();
    }

    @GetMapping("/add")
    public @ResponseBody List<Student> addStudentGet(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        studRepos.save(student);
        return Collections.singletonList(student);
    }

    @PostMapping
    public String addStudentPost(@RequestParam String name,
                                 @RequestParam int age,
                                 @RequestParam String groupName,
                                 Map<String, Object> model){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        Iterable<UniGroup> groupList = groupRepos.findAll();

        for (UniGroup group : groupList){
            if(group.getName().equals(groupName)){
                student.setGroup(group);
                break;
            }
        }
        if(student.getGroup() == null){

        } else {
        studRepos.save(student);
        Iterable<Student> studList = studRepos.findAll();
        model.put("students", studList);
        model.put("groups", groupList);
        return "main";
        }
        return "error";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Student> list = studRepos.findAll();
        Iterable<UniGroup> groupList = groupRepos.findAll();
        model.put("groups", groupList);
        model.put("students", list);
        return "main";
    }

    @GetMapping("/getByGroup")
    public @ResponseBody
    List<Student> getAllByGroup(@RequestParam(name = "group") String groupName) {
        return studRepos.findStudentsByGroupName(groupName);
    }

    @GetMapping("/getByTeacher")
    public @ResponseBody List<Student> getStudentsByTeacher(@RequestParam(name = "teacher") String teacherName){
        List<UniGroup> groupList = groupRepos.findUniGroupsByTeacherName(teacherName);
        Set<Student> studentSet = new HashSet<>();
        for(UniGroup group : groupList){
            List<Student> studentList = studRepos.findStudentsByGroupName(group.getName());
            studentSet.addAll(studentList);
        }
        List<Student> studentList = new ArrayList<>();
        studentList.addAll(studentSet);
        return studentList;
    }

}
