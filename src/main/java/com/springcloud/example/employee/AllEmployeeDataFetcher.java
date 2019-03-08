package com.springcloud.example.employee;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllEmployeeDataFetcher implements DataFetcher<List<Employee>> {


    @Override
    public List<Employee> get(DataFetchingEnvironment dataFetchingEnvironment) {

        List<Employee> empLst = new ArrayList<>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("test");
        empLst.add(emp);


        return empLst;
    }
}