package student.demo.pro.parcticePro.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.demo.pro.parcticePro.entity.Employee;

@Repository

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
