package com.alex.spring.rest.RestController;

import com.alex.spring.rest.entity.Employee;
import com.alex.spring.rest.exception_handling.NoSuchEmployeeException;
import com.alex.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private final EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> allEmployees() {
        List<Employee> allEmployees = service.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id, Employee emp) {
        Employee employee = service.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("there is no employee with id = " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = service.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException("There is now employee with id = "+id);
        }

        service.deleteEmployee(id);
        return "Employee with id " + id + " was deleted";
    }

    @Autowired
    public MyRestController(EmployeeService service) {
        this.service = service;
    }
}
