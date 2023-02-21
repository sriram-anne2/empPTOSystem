package com.codeproject.labcorp.controller;

import com.codeproject.labcorp.domain.Employee;
import com.codeproject.labcorp.service.InitService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class ActionController {

    ArrayList<Employee> listOfEmployees = new InitService().initEmployess();

    @GetMapping("")
    public ArrayList<Employee> getAllEmployees() {
        return listOfEmployees;
    }

    @PostMapping("/work")
    public Employee workEmp(@RequestHeader String empId, @RequestHeader int daysWorked) throws Exception {

        Optional<Employee> matchingEmp = listOfEmployees.stream().filter(emp -> emp.empId.equals(empId)).findFirst();
        Employee employee = matchingEmp.orElse(null);
        if (employee == null) {
            throw new Exception("No employee found with provided empId");
        }

        if (daysWorked < 0 || daysWorked > 260){
            throw new Exception("Need to have a valid number of days worked between 0 and 260");
        }
        employee.work(daysWorked);

        return employee;
    }

    @PostMapping("/vacation")
    public Employee takeVacayEmp(@RequestHeader String empId, @RequestHeader double vacay) throws Exception {

        Optional<Employee> matchingEmp = listOfEmployees.stream().filter(emp -> emp.empId.equals(empId)).findFirst();
        Employee employee = matchingEmp.orElse(null);
        if (employee == null) {
            throw new Exception("No employee found with provided empId");
        }

        if (vacay > employee.vacationDays){
            throw new Exception("Can not take more days than what employee has accrued");
        }

        employee.takeVacation(vacay);

        return employee;
    }

}
