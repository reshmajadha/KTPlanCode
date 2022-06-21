package student.demo.pro.parcticePro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import student.demo.pro.parcticePro.entity.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer>{

}
