package student.demo.pro.parcticePro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import student.demo.pro.parcticePro.entity.Employee;
import student.demo.pro.parcticePro.repo.EmployeeRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyThread2 extends Thread{
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        List<Employee> employeeList = employeeService.addEmployee();
        int size = employeeList.size();
        List<Employee> emp2 = new ArrayList<>(employeeList.subList( size / 3,2*size/3));
        for (Employee employee : emp2) {
            employeeRepo.save(employee);
        }
    }
}
