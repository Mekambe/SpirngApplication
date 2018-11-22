package com.sda.javapoz11.hellospring.hellospring.repository;

import com.sda.javapoz11.hellospring.hellospring.entity.User;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long> {
    List<User> findByLastName (String lastName);

}
