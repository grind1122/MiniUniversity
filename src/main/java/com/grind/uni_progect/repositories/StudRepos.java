package com.grind.uni_progect.repositories;

import com.grind.uni_progect.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudRepos extends CrudRepository<Student, Long> {
}
