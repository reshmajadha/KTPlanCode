package student.demo.pro.parcticePro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.demo.pro.parcticePro.entity.Employee;
import student.demo.pro.parcticePro.repo.EmployeeRepo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CompletableFeture {
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    EmployeeRepo employeeRepo;

    public String save(List<Employee> employees){
        for(Employee employee: employees){
            employeeRepo.save(employee);
        }
        return "Record inserted successfully";
    }

    public CompletableFuture<String> addEmp(){
        List<Employee> employeeList = employeeService.addEmployee();
        int size=employeeList.size();
        List<Employee> emp1=employeeList.subList(0,size/3);
        List<Employee> emp2=employeeList.subList(size/3,2*size/3);
        List<Employee> emp3=employeeList.subList(2*size/3,size);
        return CompletableFuture.supplyAsync(()->save(emp1))
                .thenApplyAsync(aVoid->save(emp2))
                .thenApply(aVoid->save(emp3));
    }
}
