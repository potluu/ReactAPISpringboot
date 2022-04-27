package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Banner;
import com.ecommerce.project.laptop.reponsitory.BannerReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.EmptyStackException;
import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerReponsitory bannerReponsitory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Banner getById(long id) {
        return bannerReponsitory.findById(id).orElseThrow(()->new EmptyStackException());
    }

    @Override
    public boolean deleteById(long id) {
        if(bannerReponsitory.existsById(id)) {
            bannerReponsitory.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Banner updateBanner(Banner banner) {

        return bannerReponsitory.save(banner);
    }

    @Override
    public List<Banner> findAll() {
        return bannerReponsitory.findAll();
    }

    @Override
    public Banner save(Banner banner) {
        return bannerReponsitory.save(banner);
    }

    @Override
    public List<Banner> searchBanner(String keyword) {
        return null;
    }

    @Override
    public List<Banner> sort(String character, String title) {
        return null;
    }
}
