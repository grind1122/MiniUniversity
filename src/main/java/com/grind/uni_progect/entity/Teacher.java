package com.grind.uni_progect.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private Collection<UniGroup> uniGroups;


    public Collection<UniGroup> getUniGroups() {
        return uniGroups;
    }

    public void setUniGroups(Collection<UniGroup> uniGroups) {
        this.uniGroups = uniGroups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
