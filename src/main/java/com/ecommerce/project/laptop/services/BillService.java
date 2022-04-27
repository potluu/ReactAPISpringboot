package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Account;
import com.ecommerce.project.laptop.entitty.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getAllBill();

    Bill getBillById(long id);

    Bill getBillUser(Account user);

    Bill saveBill(Bill bill);

     boolean deleteById(long id);

    boolean ecxitsById(long id);
}



