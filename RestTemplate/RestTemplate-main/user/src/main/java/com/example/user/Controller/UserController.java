package com.example.user.Controller;

import com.example.user.Model.User;
import com.example.user.Repository.UserRepo;
import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    private UserRepo repo;
//
//    @Autowired
//    private RestTemplate restTemplate;
//    @PostMapping("/save")
//    public ResponseEntity<User> submitu(@RequestBody User user)
//    {
//        return ResponseEntity.ok().body(repo.save(user));
//    }
//    @GetMapping("/usr")
//    public ResponseEntity<List<User>> getall()
//    {
//        return ResponseEntity.ok().body(repo.findAll());
//    }
//    @GetMapping("/{uid}")
//    public ResponseEntity<ResponseTemplateVO> findUserWithDept(@PathVariable int uid)
//    {
//        ResponseTemplateVO op=new ResponseTemplateVO();
//        User user=repo.findByUid(uid);
//        if(user==null)
//        {
//            return ResponseEntity.notFound().build();
//        }
//        Department department=restTemplate.getForObject("http://DEPARTMENT/department/"+user.getDid(), Department.class);
//        op.setUser(user);
//        op.setDepartment(department);
//        return ResponseEntity.ok().body(op);
//    }

//    ......Aishu......

    @Autowired
    private UserRepo repo;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok().body(repo.save(user));
    }

    @GetMapping("/usr")
    public ResponseEntity<List<User>> getAllUsr() {
        return ResponseEntity.ok().body(repo.findAll());

    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable int userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User usr = repo.findByUserId(userId);
        if (usr == null) {
            return ResponseEntity.notFound().build();
        }
        Department department=restTemplate.getForObject("http://localhost:8081/department/"+usr.getDeptId(),Department.class);
        vo.setUser(usr);
        vo.setDepartment(department);
        return ResponseEntity.ok().body(vo);
    }
    @PutMapping("/{deptid}")
    public ResponseEntity<Department> updateByDeptId(@PathVariable int deptId,@RequestBody Department dep){
        restTemplate.put("http://localhost:8081/department/{did}",dep,deptId,Department.class);
        return ResponseEntity.ok(dep);
    }

    @DeleteMapping("/{deptid}")
    public ResponseEntity<String> deleteByDeptId(@PathVariable int deptId){
        restTemplate.delete("http://localhost:8081/department/{did}",deptId);
        return ResponseEntity.ok("deleted");
    }

}

