package student.demo.pro.parcticePro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import student.demo.pro.parcticePro.entity.Employee;
import student.demo.pro.parcticePro.repo.EmployeeRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyThread1 extends Thread {
//    public void setEmployeeService(EmployeeServiceImpl employeeService) {
//        this.employeeService = employeeService;
//    }

@Autowired
      EmployeeServiceImpl employeeService;


//    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
//        this.employeeRepo = employeeRepo;
//    }
@Autowired
     EmployeeRepo employeeRepo;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
       List<Employee> employeeList = employeeService.addEmployee();
        int size = employeeList.size();
        List<Employee> emp2 = new ArrayList<>(employeeList.subList( 0,size / 3));
        for (Employee employee : employeeList) {
            employeeRepo.save(employee);
        }
    }
}
