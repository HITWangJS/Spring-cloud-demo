package com.edu.test.repository;

import org.springframework.stereotype.Component;
import com.edu.test.model.Employee;

@Component
public class EmployeeRepository {
    public Employee findByIntranetId(String intranetId) {
        Employee employee = new Employee();
        employee.setId("testId");
        employee.setIntranetId("testIntranetId");
        employee.setEmployee_systemrole("employee");
        employee.setEmployee_identification("eeece5dbc6e6886dcbe580c62d0b66d0");
        return employee;
    }

}
