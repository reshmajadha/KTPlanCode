package student.demo.pro.parcticePro.Utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import student.demo.pro.parcticePro.entity.Employee;
import student.demo.pro.parcticePro.repo.EmployeeRepo;
import student.demo.pro.parcticePro.service.MyThread1;
import student.demo.pro.parcticePro.service.MyThread2;
import student.demo.pro.parcticePro.service.MyThread3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpComman {

   // ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    MyThread1 thread1;
    @Autowired
    MyThread2 thread2;
    @Autowired
    MyThread3 myThread3;

    Employee emp=new Employee();

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




}
