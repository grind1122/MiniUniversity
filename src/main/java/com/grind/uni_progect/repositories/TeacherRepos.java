package com.grind.uni_progect.repositories;

import com.grind.uni_progect.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepos extends CrudRepository<Teacher, Long> {

}
