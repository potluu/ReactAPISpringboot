package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Account;
import com.ecommerce.project.laptop.entitty.Bill;
import com.ecommerce.project.laptop.reponsitory.BillReponsitory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Log4j2
public class BillServiceImpl implements BillService {
    @Autowired
    private BillReponsitory billReponsitory;

    @Override
    public List<Bill> getAllBill() {
        return billReponsitory.findAll();
    }

    @Override
    public Bill getBillById(long id) {
        return billReponsitory.getById(id);
    }

    @Override
    public Bill getBillUser(Account account) {
        Bill bill = null;
        List<Bill> list = billReponsitory.findAll();
        for (Bill b : list) {
            if (b.getUser().getAccount().getId() == account.getId()) {
                bill = b;
                break;
            }
        }

        return bill;
    }

    @Override
    public Bill saveBill(Bill bill) {
        return billReponsitory.save(bill);
    }

    @Override
    public boolean deleteById(long id) {
        if (billReponsitory.existsById(id)) {
            billReponsitory.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean ecxitsById(long id) {
        if(billReponsitory.existsById(id)){
            return true;
        }
        return false;
    }
}
