package com.netcracker.students.springmvc.dao.employee.impl;

import com.netcracker.students.springmvc.dao.AbstractDAO;
import com.netcracker.students.springmvc.dao.employee.EmployeeDAO;
import com.netcracker.students.springmvc.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDAO")
public class EmployeeDAOImpl extends AbstractDAO<Integer, Employee> implements EmployeeDAO {

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Employee findById(int id) {
        return getByKey(id);
    }

    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = createEntityCriteria();
        return (List<Employee>) criteria.list();
    }

    public Employee findEmployeeBySsn(String ssn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }
}
