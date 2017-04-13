package com.netcracker.students.springmvc.service.impl;

import com.netcracker.students.springmvc.dao.employee.EmployeeDAO;
import com.netcracker.students.springmvc.model.Employee;
import com.netcracker.students.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO dao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO dao) {
        this.dao = dao;
    }

    public Employee findById(int id) {
        return dao.findById(id);
    }

    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        Employee entity = dao.findById(employee.getId());
        if(entity!=null){
            entity.setName(employee.getName());
            entity.setJoiningDate(employee.getJoiningDate());
            entity.setSalary(employee.getSalary());
            entity.setSsn(employee.getSsn());
        }
    }

    public void deleteEmployeeBySsn(String ssn) {
        dao.deleteEmployeeBySsn(ssn);
    }

    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    public Employee findEmployeeBySsn(String ssn) {
        return dao.findEmployeeBySsn(ssn);
    }

    public boolean isEmployeeSsnUnique(Integer id, String ssn) {
        Employee employee = findEmployeeBySsn(ssn);
        return ( employee == null || ((id != null) && (employee.getId() == id)));
    }
}
