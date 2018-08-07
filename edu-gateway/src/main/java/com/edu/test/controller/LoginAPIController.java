package com.edu.test.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.test.bean.ResponseBean;
import com.edu.test.model.Employee;
import com.edu.test.repository.EmployeeRepository;
import com.edu.test.utils.JWTUtil;

@RestController
public class LoginAPIController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/login")
    public ResponseBean login(@RequestParam("username") String username, @RequestParam("password") String password)
            throws LoginException {
        // TODO: 原本有IBM 用户名密码验证的动作， 此处省略
        Employee employee = repository.findByIntranetId(username);
        if (null == employee) {
            throw new LoginException("User not registered");
        } else {
            String token = JWTUtil.sign(username, employee.getEmployee_identification(),
                    employee.getEmployee_systemrole());
            return new ResponseBean(200, "Login success", token);
        }
    }

}
