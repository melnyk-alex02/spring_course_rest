package com.alex.spring.rest.service;

import com.alex.spring.rest.DAO.Employee_dao;
import com.alex.spring.rest.DAO.Employee_dao_impl;
import com.alex.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Component
public class EmployeeServiceImpl implements EmployeeService{

    private final Employee_dao employeeDao;
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
    @Autowired
    public EmployeeServiceImpl(Employee_dao employee_dao){
        this.employeeDao = employee_dao;
    }
}
