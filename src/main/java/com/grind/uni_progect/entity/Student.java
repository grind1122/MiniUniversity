package com.grind.uni_progect.entity;

import javax.persistence.*;

@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private UniGroup group;

    public UniGroup getGroup() {
        return group;
    }

    public void setGroup(UniGroup group) {
        this.group = group;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
