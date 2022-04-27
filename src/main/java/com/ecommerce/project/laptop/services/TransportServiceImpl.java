package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Transpost;
import com.ecommerce.project.laptop.reponsitory.TransportReponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TransportServiceImpl implements TransportService {

    private final TransportReponsitory transportReponsitory;

    @Override
    public List<Transpost> getALlTranspost() {
        return transportReponsitory.findAll();
    }

    @Override
    public Transpost getTranspostById(long id) {
        return transportReponsitory.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(long id) {
        if(transportReponsitory.existsById(id)){
            transportReponsitory.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Transpost saveTranspost(Transpost transpost) {
        return transportReponsitory.save(transpost);
    }

    @Override
    public Transpost updateTranspost(Transpost transpost) {
        return transportReponsitory.save(transpost);
    }

    @Override
    public boolean existById(long id) {
        if(transportReponsitory.existsById(id)){
            return true;
        }
        return false;
    }
}
