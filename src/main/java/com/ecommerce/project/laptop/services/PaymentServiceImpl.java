package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Payment;
import com.ecommerce.project.laptop.reponsitory.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(long id) {
        if(paymentRepository.existsById(id)){
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }



    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
