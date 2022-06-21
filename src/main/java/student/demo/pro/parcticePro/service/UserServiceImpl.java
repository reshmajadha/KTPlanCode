package student.demo.pro.parcticePro.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.demo.pro.parcticePro.entity.User;
import student.demo.pro.parcticePro.repo.UserRepo;

import java.util.List;

@Service
public class UserServiceImpl {
@Autowired
     UserRepo userRepo;


public User getUserByID(int id){
       return userRepo.findById(id).get();
}

    public List<User> getUser() {
       return userRepo.findAll();
    }

    public User insertUser(User user) {
       return userRepo.save(user);
    }

    public String deleteById(int id) {
    String s="Record is deleted";
    userRepo.deleteById(id);
    return s;


    }

}

