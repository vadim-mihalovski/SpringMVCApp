package com.netcracker.students.springmvc.dao.employee;

import com.netcracker.students.springmvc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String ssn);

}
