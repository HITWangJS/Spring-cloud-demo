package com.edu.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.test.bean.PermisionBean;
import com.edu.test.bean.ResponseBean;
import com.edu.test.utils.AuthorizationUtils;

@RestController
public class APIController {

    @GetMapping("/eduService")
    @RequiresAuthentication
    public String serviceTest(HttpServletRequest reqeust) {
        String Authorization = reqeust.getHeader("Authorization");
        return "service connect success, token is: " + Authorization;
    }
    
    @GetMapping("/showPermission")
    @RequiresAuthentication
    public ResponseBean permissionList() {
        PermisionBean permission = new PermisionBean(AuthorizationUtils.getRoles(),
                AuthorizationUtils.getPermissions());
        return new ResponseBean(200, "success", permission);
    }
    
    @RequiresRoles("manager")
    @GetMapping("/eduPermission")
    public String permissionTest() {
        return "manager role access";
    }
}
