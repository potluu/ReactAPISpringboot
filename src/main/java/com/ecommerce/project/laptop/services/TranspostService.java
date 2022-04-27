package com.ecommerce.project.laptop.services;


import com.ecommerce.project.laptop.entitty.Transpost;

import java.util.List;

public interface TranspostService {

    List<Transpost> getALlTranspost();

     Transpost getTranspostById(long id);

     boolean deleteById(long id);

     Transpost saveTranspost(Transpost Transpost);

     Transpost updateTranspost(Transpost Transpost);

    boolean existById(long id);
}
