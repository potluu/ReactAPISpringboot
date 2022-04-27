package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayment();

    Payment getById(long id);

    boolean deleteById(long id);

    Payment savePayment(Payment payment);

    Payment updatePayment(Payment payment);
}
