package com.example.hello.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.hello.model.Employee;

@Service
public class EmployeeService {
    Map<String, Employee> employeeRepo; // Simulating a repository

    public String getEmployeeById(String id) {
        // In a real application, this would fetch data from a database
        return "Employee with ID: " + id;
    }

    public Employee createEmployee(Employee employee) {
        // In a real application, this would save the employee to a database
        return employee;
    }  
    
    public Map<String, Employee> getAllEmployees() {
        return employeeRepo;
    }

    // public static void main(String[] args) {
    //     EmployeeService employeeService = new EmployeeService();
    //     employeeService.getSecondGradeSalaryEachDept();
    // }
    public Map<String, Employee> getSecondGradeSalaryEachDept() {
        Employee emp1 = new Employee("1", "Alice", "IT", 50000);
        Employee emp2 = new Employee("2", "Bob", "IT", 60000);
        
        Employee emp5 = new Employee("5", "Bob3", "IT", 65000);
        Employee emp3 = new Employee("3", "Charlie", "HR", 55000); 
        Employee emp4 = new Employee("4", "David", "HR", 65000); 
        Employee emp6 = new Employee("6", "Eve", "HR", 70000); 
        
        employeeRepo = new HashMap<>();
        employeeRepo.put(emp1.getId(), emp1);
        employeeRepo.put(emp2.getId(), emp2);
        employeeRepo.put(emp3.getId(), emp3);   
        employeeRepo.put(emp4.getId(), emp4);
        employeeRepo.put(emp5.getId(), emp5);
        employeeRepo.put(emp6.getId(), emp6);

        Stream<Map.Entry<String, Employee>> employeeByDept = employeeRepo.entrySet()
            .stream()
            //.sorted(Comparator.comparing(entry -> entry.getValue().getDepartment() + entry.getValue().getSalary()))
            .sorted(Comparator.comparing(entry -> entry.getValue().getDepartment()))
            // .sorted(Comparator.comparing(entry -> entry.getValue().getSalary()))
            ;
        
       
            System.out.println(employeeByDept.toList());
            Map<String, Employee> result = new HashMap<>();
            AtomicReference<String> lastIndexKey = new AtomicReference<>("");
            AtomicInteger countIndexSal = new AtomicInteger(1)  ;
            // Get distinct departments
            // .sorted(Order.ascendingBy(entry -> entry.getValue().getDepartment())) // Sort by department
            // .filter(entry -> entry.getValue().getDepartment().equals(""))
            
             employeeRepo.entrySet()
            .stream()
            .sorted(Comparator.comparing(entry -> entry.getValue().getDepartment()))
            .forEach(entry -> {
                System.out.println(entry.getValue().getDepartment() + " - " + entry.getValue().getSalary());
                if(entry.getValue().getDepartment().equals(lastIndexKey.get())) {
                    // same department, calculate second grade salary
                    countIndexSal.incrementAndGet();
                   
                    if(countIndexSal.get() == 2) {
                        //print resutl
                        result.put(entry.getKey(), entry.getValue());
                        // Calculate second grade salary for current department
                    }
                } else  {
                    countIndexSal.set(1); // reset count for new department
                    lastIndexKey.set(entry.getValue().getDepartment()); // update last index key to current department
                    // Calculate second grade salary for IT department
                }
                // Employee emp = entry.getValue();
                // // Assuming we have a method to calculate second grade salary
                // double secondGradeSalary = 0L;
                // emp.setDepartment(emp.getDepartment() + " - Second Grade Salary: " + secondGradeSalary);
                // lastIndexKey = entry.getKey();   
            });
            System.out.println("-------------------");
            System.out.println(result);
        return result;
    }
}
