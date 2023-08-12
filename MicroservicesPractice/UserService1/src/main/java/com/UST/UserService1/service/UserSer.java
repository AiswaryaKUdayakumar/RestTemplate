package com.UST.UserService1.service;

import com.UST.UserService1.VO.Department;
import com.UST.UserService1.VO.ResponseTemplateVO;
import com.UST.UserService1.entity.User;
import com.UST.UserService1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserSer {
    @Autowired
    private UserRepo repo;
    @Autowired
    public RestTemplate resTemplate;

    public User save(User user) {
        return repo.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user=repo.findByUserId(userId);
        Department department=resTemplate.getForObject("http://localhost:9096/department/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;

    }
}
