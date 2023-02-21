package com.codeproject.labcorp.domain;

import org.springframework.stereotype.Component;

@Component
public class MEmployee extends Employee {

    public MEmployee(){
        super();
        employeeType = EmployeeType.Manager;
        vacationAccrual = 30;
    }
    @Override
    public void work(int numDaysWorked) {
        vacationDays = vacationAccrual * numDaysWorked / 260;
    }
}
