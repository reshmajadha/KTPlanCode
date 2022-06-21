package student.demo.pro.parcticePro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import student.demo.pro.parcticePro.entity.User;
import student.demo.pro.parcticePro.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/")

public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserByID(id);
    }
    @GetMapping("allUser")
        public List<User>getUser(){
        return userService.getUser();
    }
@PostMapping("insertUser")
    public User insert(@RequestBody User user){
        return userService.insertUser(user);
}
@DeleteMapping("deleteById/{id}")
    public String delete(@PathVariable int id){
        return userService.deleteById(id);
}

}
