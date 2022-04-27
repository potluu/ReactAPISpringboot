package com.ecommerce.project.laptop.services;


import com.ecommerce.project.laptop.entitty.Notify;

import java.util.List;

public interface NotifyService {
    List<Notify> getAllNotify();

    Notify getById(long id);

    boolean deleteById(long id);

    Notify saveCNotify(Notify notify);




}
