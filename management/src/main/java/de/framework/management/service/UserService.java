package de.framework.management.service;

import de.framework.management.exception.UserNotFoundException;
import de.framework.management.model.User;
import de.framework.management.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired//???
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        user.setUserCode(UUID.randomUUID().toString());//?? UUID??
        return userRepo.save(user);
    }

    //to list all the user
    public List<User> findAllUser(){
        return userRepo.findAll();
    }


    //update User
    public User updateUser(User user){
        return userRepo.save(user);
    }

    public User findUserById(Long id){
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("user by id "+ id + "not found"));
    }
    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }

}
