package com.edu.test.utils;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;

import com.edu.test.shiro.ShiroRealm;


public class AuthorizationUtils {

    public static String getPermissions() {
        ShiroRealm realm = new ShiroRealm();
        StringBuilder builder = new StringBuilder();
        Set<String> permissions = (Set<String>) realm.getAuthorizationInfo(SecurityUtils.getSubject().getPrincipals())
                .getStringPermissions();
        if (CollectionUtils.isEmpty(permissions)) {
            return null;
        }
        for (String permission : permissions) {
            builder.append(permission);
            builder.append(",");
        }
        return StringUtils.removeEnd(builder.toString(), ",");
    }

    public static String getRoles() {
        ShiroRealm realm = new ShiroRealm();
        StringBuilder builder = new StringBuilder();
        Set<String> roles = (Set<String>) realm.getAuthorizationInfo(SecurityUtils.getSubject().getPrincipals())
                .getRoles();
        if (CollectionUtils.isEmpty(roles)) {
            return null;
        }
        for (String role : roles) {
            builder.append(role);
            builder.append(",");
        }
        return StringUtils.removeEnd(builder.toString(), ",");
    }

    public static String getUsername(Subject subject) {
        PrincipalCollection principals = subject.getPrincipals();
        return JWTUtil.getUsername(principals.toString());
    }
}
