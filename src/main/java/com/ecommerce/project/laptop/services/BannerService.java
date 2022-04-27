package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Banner;

import java.util.List;

public interface BannerService {
    Banner getById(long id);

    boolean deleteById(long id);

    Banner updateBanner(Banner banner);

    List<Banner> findAll();

    Banner save(Banner banner);

    List<Banner> searchBanner(String keyword);

    List<Banner> sort(String character,String title);
}
