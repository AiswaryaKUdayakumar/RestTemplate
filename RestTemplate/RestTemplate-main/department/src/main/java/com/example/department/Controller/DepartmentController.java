package com.example.department.Controller;

import com.example.department.Entity.Department;
import com.example.department.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
//    @Autowired
//    private DepartmentRepo repo;
//
//    @PostMapping("/submit")
//    public ResponseEntity<Department>submit(@RequestBody Department department){
//        return ResponseEntity.ok().body(repo.save(department));
//    }
//    @GetMapping("/dept")
//    public ResponseEntity<List<Department>>getalldept(){
//        return ResponseEntity.ok().body(repo.findAll());
//    }
////    @GetMapping("/{id}")
////    public ResponseEntity<Optional<Department>> getbyid(@PathVariable int id)
////    {
////
////        return ResponseEntity.ok().body(repo.findById(id));
////
////    }
////
//    @GetMapping("/{did}")
//    public ResponseEntity<Department>getbyid(@PathVariable int did){
//        Department department=repo.findByDid(did);
//        if(department==null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(department);
//
//    }

//    ......Aishu......
    @Autowired
    private DepartmentRepo repo;

    @PostMapping("/")
    public ResponseEntity<Department> save(@RequestBody Department department){
        return ResponseEntity.ok().body(repo.save(department));
    }
    @GetMapping("/dept")
    public ResponseEntity<List<Department>> getAllDept(){
        return ResponseEntity.ok().body(repo.findAll());
    }
    @GetMapping("/{deptId}")
    public ResponseEntity<Department> getDeptById(@PathVariable int deptId){
        Department department=repo.findById(deptId).orElse(null);
        if(department==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(department);
    }
//    @GetMapping("/{deptId}")
//    public ResponseEntity<Department> getDeptById(@PathVariable int deptId){
//        Department dep=null;
//        Optional<Department> departmen=repo.getBydeptId(deptId);
//        if(departmen.isPresent()){
//            return ResponseEntity.ok().body(departmen.get());
//
//        }
//        return ResponseEntity.notFound().build();
//    }
    @PutMapping("/{deptId}")
    public ResponseEntity<Department> updateDeptById(@PathVariable int deptId,@RequestBody Department department){
        Department dept=null;
        Optional<Department> departmen=repo.findById(deptId);
        if(departmen.isPresent()){
            dept.getDepName();
            dept.getDepCode();
            dept.setDepName(department.getDepName());
            dept.setDepCode(department.getDepCode());
        }
        return ResponseEntity.ok(repo.save(dept));
    }
    @DeleteMapping("/{deptId}")
    public String deleteById(@PathVariable int deptId){
        Department dept=repo.findBydeptId(deptId);
        if(dept!=null){
            repo.deleteBydeptId(deptId);
        }
        return "deleted..";
    }

}


