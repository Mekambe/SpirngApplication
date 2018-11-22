package com.sda.javapoz11.hellospring.hellospring.service;


import com.sda.javapoz11.hellospring.hellospring.entity.User;
import com.sda.javapoz11.hellospring.hellospring.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    public User findById (long id) {
return usersRepository.findById(id) //wzielo sie z cruda
        .orElse(null);
    }

    public List<User> findAll(){
        List<User> users = new ArrayList<>();

       usersRepository.findAll().forEach(e->users.add(e));
        return users;
    }

    public List<User> findByLastName (String lastName){
        return usersRepository.findByLastName(lastName);
    }

    @PostConstruct
    private void init(){
        usersRepository.save(User.builder().firstName("Szymon").lastName("Nowak").age(23).build());
        usersRepository.save(User.builder().firstName("Szymon2").lastName("Walak").age(24).build());
        usersRepository.save(User.builder().firstName("Szymon3").lastName("Marak").age(25).build());
        usersRepository.save(User.builder().firstName("Kasia").lastName("Nowak").age(25).build());

    }
}
