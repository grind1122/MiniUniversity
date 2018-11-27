package com.grind.uni_progect;

import com.google.common.collect.ImmutableList;
import com.grind.uni_progect.entity.Teacher;
import com.grind.uni_progect.entity.UniGroup;
import com.grind.uni_progect.repositories.GroupRepos;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GroupControllerTest {

    @Mock
    private GroupRepos groupRepos;

    @InjectMocks
    GroupController sut;

    @Test
    public void getAllByTeacher() {
//        prepare
        String teacherName = "Teacher";
        when(groupRepos.findUniGroupsByTeacherName(teacherName)).thenReturn(new ArrayList<>());

//        testing
        List<UniGroup> list = sut.getAllByTeacher(teacherName);

//        validate
        Mockito.verify(groupRepos, times(1)).findUniGroupsByTeacherName(teacherName);
    }
}