package com.codeproject.labcorp.domain;

import org.springframework.stereotype.Component;

@Component
public class HEmployee extends Employee {
    public HEmployee(){
        super();
        employeeType = EmployeeType.Hourly;
        VACATION_ACCRUAL = 10;
    }
    @Override
    public void work(int numDaysWorked) {
        vacationDays = VACATION_ACCRUAL * numDaysWorked / 260;
    }
}
