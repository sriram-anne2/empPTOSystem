package com.codeproject.labcorp.service;

import com.codeproject.labcorp.domain.Employee;
import com.codeproject.labcorp.domain.HEmployee;
import com.codeproject.labcorp.domain.MEmployee;
import com.codeproject.labcorp.domain.SEmployee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InitService {

    private static final int NUM_OF_EACH_EMPLOYEES = 10;
    @PostConstruct
    public ArrayList<Employee> initEmployess(){

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < NUM_OF_EACH_EMPLOYEES; i ++){
            HEmployee hEmployee = new HEmployee();
            SEmployee sEmployee = new SEmployee();
            MEmployee mEmployee = new MEmployee();

            hEmployee.setEmpId(genRandomEmpId());
            sEmployee.setEmpId(genRandomEmpId());
            mEmployee.setEmpId(genRandomEmpId());

            employees.add(hEmployee);
            employees.add(sEmployee);
            employees.add(mEmployee);
        }

        return employees;
    }

    private String genRandomEmpId(){

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(5);

        for (int i = 0; i < 3; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

}
