package com.grind.uni_progect;

import com.grind.uni_progect.entity.UniGroup;
import com.grind.uni_progect.repositories.GroupRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupRepos repos;


    @GetMapping("/getAll")
    public @ResponseBody List<UniGroup> getAll(){
        return (List<UniGroup>) repos.findAll();
    }
}
