package com.grind.uni_progect.repositories;

import com.grind.uni_progect.entity.UniGroup;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface GroupRepos extends CrudRepository<UniGroup, Long> {

    List<UniGroup> findUniGroupsByTeacherName(String teacherName);

}
