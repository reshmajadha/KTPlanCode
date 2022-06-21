package student.demo.pro.parcticePro.service;

import org.springframework.data.jpa.repository.JpaRepository;
import student.demo.pro.parcticePro.ExceptionHandling.nameException;
import student.demo.pro.parcticePro.Model.EmpReq;
import student.demo.pro.parcticePro.entity.Employee;

import java.util.List;

public interface EmployeeService  {
    public Employee CreateEmp(EmpReq empReq) throws nameException;
    public List<Employee> allEmployee();
    public Object updateEmp(Integer id, Employee employee);
}
