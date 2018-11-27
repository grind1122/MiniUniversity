package com.grind.uni_progect;

import com.google.common.collect.ImmutableList;
import com.grind.uni_progect.entity.Student;
import com.grind.uni_progect.entity.UniGroup;
import com.grind.uni_progect.repositories.StudRepos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GroupControllerTest {

    @Mock
    private StudRepos studRepos;

    @InjectMocks
    StudentController sut;

    @Test
    public void getStudentsByGroup() {
//        prepare
        String groupName = "IT";
        when(studRepos.findStudentsByGroupName(groupName)).thenReturn(new ArrayList<>());

//        testing
        List<Student> list = sut.getAllByGroup(groupName);

//        validate
        Mockito.verify(studRepos, times(1)).findStudentsByGroupName(groupName);

    }
}