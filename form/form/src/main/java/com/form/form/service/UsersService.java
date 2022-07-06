package com.form.form.service;

import com.form.form.model.UserModel;
import com.form.form.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    //Getting user repository
    private final UsersRepository usersRepository;            //Autowiring thru field is not preferable hence use it via constructor

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    //Register User
    public UserModel registerUser(String login, String password, String email){
        if(login !=null && password !=null){
            UserModel userModel = new UserModel() ;
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setEmail(email);
            return usersRepository.save(userModel);
        }
        else {
            return null;
        }
    }

    //Authenticate User
    public UserModel authenticateUser(String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
