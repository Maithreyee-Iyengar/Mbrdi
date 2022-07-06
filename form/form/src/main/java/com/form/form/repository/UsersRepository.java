package com.form.form.repository;

import com.form.form.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//When we extend Jpa repository our userRepository will have default CRUD methods.
public interface UsersRepository extends JpaRepository<UserModel, Integer> {

    //custom method

    Optional<UserModel> findByLoginAndPassword(String login , String password);
}


