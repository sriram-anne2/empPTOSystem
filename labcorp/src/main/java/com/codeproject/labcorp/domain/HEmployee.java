package com.codeproject.labcorp.domain;

import org.springframework.stereotype.Component;

@Component
public class HEmployee extends Employee {
    public HEmployee(){
        super();
        employeeType = EmployeeType.Hourly;
        vacationAccrual = 10;
    }
    @Override
    public void work(int numDaysWorked) {
        vacationDays = vacationAccrual * numDaysWorked / 260;
    }
}
