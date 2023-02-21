package com.codeproject.labcorp.domain;

import org.springframework.stereotype.Component;

@Component
public class MEmployee extends Employee {

    public MEmployee(){
        super();
        employeeType = EmployeeType.Manager;
        VACATION_ACCRUAL = 30;
    }
    @Override
    public void work(int numDaysWorked) {
        vacationDays = VACATION_ACCRUAL * numDaysWorked / 260;
    }
}
