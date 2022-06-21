package student.demo.pro.parcticePro.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import student.demo.pro.parcticePro.ExceptionHandling.nameException;
import student.demo.pro.parcticePro.Model.EmpReq;
import student.demo.pro.parcticePro.entity.Employee;
import student.demo.pro.parcticePro.repo.EmployeeRepo;
import student.demo.pro.parcticePro.service.CompletableFeture;
import student.demo.pro.parcticePro.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/")
public class EmployeeController {

    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    CompletableFeture completableFeture;
    @PostMapping("Emp")
    public CompletableFuture<String> addEmployee1() {
        return completableFeture.addEmp();

    }

    @PostMapping("Employee1")
    public String addEmployee(){
      return   employeeService.threadCall();
    }


    @PostMapping("employee")
    public EmpReq createEmp(@RequestBody EmpReq empReq) throws nameException {
        Employee employee= employeeService.CreateEmp(empReq);
        return  objectMapper.convertValue(employee,EmpReq.class);
    }
    @GetMapping("getAll")
    public  List<Employee>allEmployee(){
        return employeeService.allEmployee();
    }

    @PutMapping("updateEmp/{id}")
    public Object updateEmp(@PathVariable Integer id,@RequestBody Employee employee){
       return employeeService.updateEmp(id,employee);

    }




}
