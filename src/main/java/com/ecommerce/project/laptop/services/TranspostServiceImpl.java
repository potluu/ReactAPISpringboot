package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Transpost;
import com.ecommerce.project.laptop.reponsitory.TranspostReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TranspostServiceImpl implements TranspostService {

    @Autowired
    private TranspostReponsitory transpostReponsitory;

    @Override
    public List<Transpost> getALlTranspost() {
        return transpostReponsitory.findAll();
    }

    @Override
    public Transpost getTranspostById(long id) {
        return transpostReponsitory.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(long id) {
        if(transpostReponsitory.existsById(id)){
            transpostReponsitory.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Transpost saveTranspost(Transpost transpost) {
        return transpostReponsitory.save(transpost);
    }

    @Override
    public Transpost updateTranspost(Transpost transpost) {
        return transpostReponsitory.save(transpost);
    }

    @Override
    public boolean existById(long id) {
        if(transpostReponsitory.existsById(id)){
            return true;
        }
        return false;
    }
}
