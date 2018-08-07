package com.edu.test.bean;

public class PermisionBean {

    private String roles;
    private String permissions;

    public PermisionBean(String roles, String permissions) {
        this.roles = roles;
        this.permissions = permissions;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermission() {
        return permissions;
    }

    public void setPermission(String permissions) {
        this.permissions = permissions;
    }
}
