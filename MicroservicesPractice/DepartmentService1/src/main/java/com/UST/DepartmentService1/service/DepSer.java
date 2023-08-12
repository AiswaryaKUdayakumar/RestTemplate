package com.UST.DepartmentService1.service;

import com.UST.DepartmentService1.entity.Department;
import com.UST.DepartmentService1.repository.DepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepSer {
    @Autowired
    private DepRepo repo;

    public Department save(Department department) {
        return repo.save(department);
    }

    public Department findDepById(Long departmentId) {
        return repo.findByDepartmentId(departmentId);
    }
}
