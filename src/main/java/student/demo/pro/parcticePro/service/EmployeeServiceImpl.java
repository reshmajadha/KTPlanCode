package student.demo.pro.parcticePro.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import student.demo.pro.parcticePro.ExceptionHandling.ResourceNotFoundException;
import student.demo.pro.parcticePro.ExceptionHandling.nameException;
import student.demo.pro.parcticePro.Model.EmpReq;
import student.demo.pro.parcticePro.entity.Employee;
import student.demo.pro.parcticePro.repo.EmployeeRepo;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Configurable
public class EmployeeServiceImpl implements EmployeeService {

    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    MyThread1 thread1;
    @Autowired
    MyThread2 thread2;
    @Autowired
    MyThread3 myThread3;

    Employee emp = new Employee();


    public List<Employee> addEmployee() {
        List<Employee> empList = new ArrayList<Employee>();
        BufferedReader br = null;
        String filePath = "D:\\Employee\\emp.txt";
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(filePath));
            while ((sCurrentLine = br.readLine()) != null) {
                String[] record = sCurrentLine.split(",");
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(record[0].trim()));
                emp.setName(record[1].trim());
                emp.setAge(Integer.parseInt(record[2].trim()));
                empList.add(emp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(empList);
        return empList;
    }

    public String threadCall() {
        thread1.start();
        thread2.start();
        myThread3.start();
        return "task done";
    }

    @Override
    public Employee CreateEmp(EmpReq empReq)throws nameException {
        try {
            emp = objectMapper.convertValue(empReq, Employee.class);
            return employeeRepo.save(emp);
        }
        catch (Exception exception){
            throw new nameException("first name not found");
        }

    }

    @Override
    public List<Employee> allEmployee() {

        return employeeRepo.findAll();
    }

    @Override
    public Object updateEmp(Integer id, Employee employee) throws ResourceNotFoundException {
        Employee e = new Employee();
        try {
             e = employeeRepo.findById(id).get();
            e.setId(employee.getId());
            e.setAge(employee.getAge());
            e.setName(employee.getName());
            employeeRepo.save(e);
            return  e;
        }  catch (Exception exception) {
           throw new ResourceNotFoundException("not found");
        }
    }


}


