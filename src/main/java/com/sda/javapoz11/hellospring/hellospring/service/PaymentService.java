package com.sda.javapoz11.hellospring.hellospring.service;

import com.sda.javapoz11.hellospring.hellospring.entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.entity.Paymentstatus;
import com.sda.javapoz11.hellospring.hellospring.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Profile("!dev")
@Service
public class PaymentService implements PaymentActions{

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }




    @Override
    public Payment findByID(Long id) {
        return paymentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void addPayment(String client, Double price) {
        Payment payment = new Payment(null,client,price,Instant.now(), Paymentstatus.DONE);
        paymentRepository.save(payment);

    }

    @PostConstruct
    private void init(){
        paymentRepository.save(Payment.builder().
                client("Jan Kowalski").
                price(45.0).
                date(Instant.now().minusSeconds(7*24*60*60))
        .status(Paymentstatus.DONE).build());
        paymentRepository.save(Payment.builder().
                client("Jan Kowalski").price(30.0).
                date(Instant.now().minusSeconds(1*24*60*60))
                .status(Paymentstatus.IN_PROGRESS).build());
        paymentRepository.save(Payment.builder().
                client("Anna Wiśniewska").price(45.0).
                date(Instant.now()
                        .minusSeconds(21*24*60*60))
                .status(Paymentstatus.CANCELED).build());


    }
}
