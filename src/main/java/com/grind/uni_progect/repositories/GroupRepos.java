package com.grind.uni_progect.repositories;

import com.grind.uni_progect.entity.Teacher;
import com.grind.uni_progect.entity.UniGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepos extends CrudRepository<UniGroup, Long> {

    List<UniGroup> findUniGroupsByTeacherName(String teacherName);

}
