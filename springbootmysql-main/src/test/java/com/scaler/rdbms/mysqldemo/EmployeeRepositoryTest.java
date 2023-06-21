package com.scaler.rdbms.mysqldemo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import codeswithpankaj.com.Employee;
import codeswithpankaj.com.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testRepositoryCreated(){
        Assertions.assertNotNull(employeeRepository);
    }

    @Test
    public void testEmployeeIsAdded(){
        Employee employee = new Employee("fn", "ln", "test@gmail.com");
        employeeRepository.save(employee);

        List<Employee> findAll = employeeRepository.findAll();

        Assertions.assertEquals(1, findAll.size());
        Assertions.assertEquals(findAll.get(0).getFirstName(), "fn");
    }
    
}
