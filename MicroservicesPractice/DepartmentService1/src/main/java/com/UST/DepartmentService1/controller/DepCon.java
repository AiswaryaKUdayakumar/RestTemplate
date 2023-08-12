package com.UST.DepartmentService1.controller;

import com.UST.DepartmentService1.entity.Department;
import com.UST.DepartmentService1.service.DepSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepCon {
    @Autowired
    private DepSer service;
    @PostMapping("/")
    public Department saveDep(@RequestBody Department department) {
        return service.save(department);
    }
    @GetMapping("/{id}")
    public Department findDepById(@PathVariable("id") Long DepartmentId){
        return service.findDepById(DepartmentId);
    }
}
