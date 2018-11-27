package com.grind.uni_progect.repositories;

import com.grind.uni_progect.entity.UniGroup;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepos extends CrudRepository<UniGroup, Long> {
}
