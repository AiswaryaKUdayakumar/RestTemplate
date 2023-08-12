package com.UST.DepartmentService1.repository;

import com.UST.DepartmentService1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepRepo extends JpaRepository<Department, Long> {




    Department findByDepartmentId(Long departmentId);
}
