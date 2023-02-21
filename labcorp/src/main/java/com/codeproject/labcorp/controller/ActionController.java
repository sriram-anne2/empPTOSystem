package com.codeproject.labcorp.controller;

import com.codeproject.labcorp.domain.Employee;
import com.codeproject.labcorp.service.InitService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/emp")
public class ActionController {

    ArrayList<Employee> listOfEmployees = new InitService().initEmployess();

    @GetMapping("")
    public ArrayList<Employee> getAllEmployees() {
        return listOfEmployees;
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable(value = "empId") String empId) throws Exception {

        return getEmpById(empId);
    }

    private Employee getEmpById(String id) throws Exception {

        Optional<Employee> matchingEmp = listOfEmployees.stream().filter(emp -> emp.empId.equals(id)).findFirst();
        Employee employee = matchingEmp.orElse(null);
        if (employee == null) {
            throw new Exception("No employee found with provided empId");
        }

        return employee;
    }

    @PostMapping("/work/{empId}")
    public Employee workEmp(@PathVariable(value = "empId") String empId, @RequestParam int daysWorked) throws Exception {

        Employee employee = getEmpById(empId);
        if (daysWorked < 0 || daysWorked > 260){
            throw new Exception("Need to have a valid number of days worked between 0 and 260");
        }
        employee.work(daysWorked);

        return employee;
    }

    @PostMapping("/vacation/{empId}")
    public Employee takeVacayEmp(@PathVariable(value = "empId") String empId, @RequestParam double vacay) throws Exception {

        Employee employee = getEmpById(empId);
        if (vacay > employee.vacationDays){
            throw new Exception("Can not take more days than what employee has accrued");
        }

        employee.takeVacation(vacay);

        return employee;
    }

}
