package com.UST.UserService1.controller;

import com.UST.UserService1.VO.Department;
import com.UST.UserService1.VO.ResponseTemplateVO;
import com.UST.UserService1.entity.User;
import com.UST.UserService1.service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserCon {
    @Autowired
    private UserSer service;
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return service.save(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartmentById(@PathVariable ("id") Long userId ){
        return service.getUserWithDepartment(userId);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long userId,@RequestBody Department dept){
        dept.setDepartmentId(dept.getDepartmentId());
        restTemplate.put("http://localhost:9095/department/"+dept.getDepartmentId(),Department.class);

    }
}
