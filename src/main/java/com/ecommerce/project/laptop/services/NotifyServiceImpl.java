package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Notify;
import com.ecommerce.project.laptop.reponsitory.NotifyReponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NotifyServiceImpl implements NotifyService {
    private final NotifyReponsitory notifyReponsitory;


    @Override
    public List<Notify> getAllNotify() {
        return notifyReponsitory.findAll();
    }

    @Override
    public Notify getById(long id) {
        return notifyReponsitory.findById(id).orElse(new Notify());
    }

    @Override
    public boolean deleteById(long id) {
        if (notifyReponsitory.existsById(id)) {
            notifyReponsitory.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Notify saveCNotify(Notify notify) {
        return notifyReponsitory.save(notify);
    }
}
