package com.example.department.Repository;

import com.example.department.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {


//    Department findByDid(int did);

//    ......Aishu......

    Department findByDeptId(int deptId);

//    Optional<Department> getBydeptId(int deptId);
//
    void deleteBydeptId(int deptId);
//
    Department findBydeptId(int deptId);
}
