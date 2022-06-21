package student.demo.pro.parcticePro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import student.demo.pro.parcticePro.entity.Employee;
import student.demo.pro.parcticePro.repo.EmployeeRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyThread3 extends Thread{

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        List<Employee> employeeList = employeeService.addEmployee();
        int size = employeeList.size();
        List<Employee> emp3 = new ArrayList<>(employeeList.subList(2*size / 3,size));
        for (Employee employee : emp3) {
            employeeRepo.save(employee);
        }
    }
}
