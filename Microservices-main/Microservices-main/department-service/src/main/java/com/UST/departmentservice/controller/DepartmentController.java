package com.UST.departmentservice.controller;

import com.UST.departmentservice.entity.Department;
import com.UST.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService services;

    @PostMapping("/")
    public  Department saveDepartmentById(@RequestBody Department department){
        return services.saveDepartmentById(department);
    }

    @GetMapping("/{id}")
    public Department findByDepartmentId(@PathVariable("id")Long departmentId){
        return services.findByDepartmentId(departmentId);
    }


}
