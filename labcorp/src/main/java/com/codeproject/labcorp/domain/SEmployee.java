package com.codeproject.labcorp.domain;

import org.springframework.stereotype.Component;

@Component
public class SEmployee extends Employee {
    public SEmployee(){
        super();
        employeeType = EmployeeType.Salaried;
        VACATION_ACCRUAL = 15;
    }
    @Override
    public void work(int numDaysWorked) {
        vacationDays = VACATION_ACCRUAL * numDaysWorked / 260;
    }
}
