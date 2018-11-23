package com.sda.javapoz11.hellospring.hellospring.repository;

import com.sda.javapoz11.hellospring.hellospring.entity.Payment;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
