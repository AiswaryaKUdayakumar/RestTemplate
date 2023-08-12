package com.UST.departmentservice.service;

import com.UST.departmentservice.entity.Department;
import com.UST.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repo;


    public Department findByDepartmentId(Long departmentId) {
        return repo.findByDepartmentId(departmentId);
    }

    public Department saveDepartmentById(Department department) {
        return repo.save(department);
    }


}
