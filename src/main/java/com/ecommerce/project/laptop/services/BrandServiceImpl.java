package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.component.Excel;
import com.ecommerce.project.laptop.entitty.Brand;
import com.ecommerce.project.laptop.reponsitory.BrandReponsitory;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.EmptyStackException;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService{


    private final BrandReponsitory brandReponsitory;


    @Override
    public List<Brand> getAllBrand() {
        return brandReponsitory.findAll();
    }

    @Override
    public Brand getById(int id) {
        return brandReponsitory.findById(id).orElseThrow(()->new EmptyStackException());
    }

    @Override
    public void deleteById(int id) {

        brandReponsitory.deleteById(id);
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandReponsitory.save(brand);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        return brandReponsitory.save(brand);
    }

    @Override
    public boolean exitsById(int id) {
        if (brandReponsitory.existsById(id)){
            return true;
        }else{
            return false;

        }
    }
}
