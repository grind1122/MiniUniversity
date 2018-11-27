package com.grind.uni_progect.repositories;

import com.grind.uni_progect.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudRepos extends CrudRepository<Student, Long> {
    List<Student> findStudentsByGroupName(String groupName);

}
