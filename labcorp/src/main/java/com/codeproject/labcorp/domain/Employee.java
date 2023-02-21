package com.codeproject.labcorp.domain;

import org.springframework.stereotype.Component;

@Component
public abstract class Employee {

    public String empId;
    public EmployeeType employeeType;
    public double vacationDays;
    public double VACATION_ACCRUAL;

    Employee(){
        vacationDays = 0;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public abstract void work(int numDaysWorked);

    public void takeVacation(double vacationDaysRequest) {
        vacationDays -= vacationDaysRequest;
    }
}
