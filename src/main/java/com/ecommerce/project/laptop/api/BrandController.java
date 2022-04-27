package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.dto.BrandDto;
import com.ecommerce.project.laptop.entitty.Brand;
import com.ecommerce.project.laptop.services.BrandServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Log4j2
public class BrandController {
    @Autowired
    private BrandServiceImpl brandService;

    /*

     */
    @GetMapping(value = "/brands")
    public ResponseEntity<List<BrandDto>> getAll() {
        List<BrandDto> listBrandDtos = new ArrayList<>();
        brandService.getAllBrand().forEach(brand ->
                listBrandDtos.add(new BrandDto(brand)));
        return new ResponseEntity<>(listBrandDtos, HttpStatus.OK);
    }

    /*

     */
    @GetMapping(value = "/brand/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") int id) {
        BrandDto brandDto = new BrandDto(brandService.getById(id));
        return new ResponseEntity<>(brandDto, HttpStatus.OK);
    }

    /*

     */
    @PostMapping(value = "/brand")
    public ResponseEntity<Boolean> save(@ModelAttribute(name = "brandDto") BrandDto brandDto) {
        Brand brand = Brand.builder().
                name(brandDto.getName())
                .build();
        brandService.saveBrand(brand);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
    /*

     */
    @DeleteMapping("/brand")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        brandService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /*

     */
    @PutMapping("/brand")
    public ResponseEntity<?> updatebrand(@ModelAttribute(name = "brandDto") BrandDto brandDto) {

        if (brandDto.getBrandId() > 0 && brandService.exitsById(brandDto.getBrandId())) {
            Brand brand = Brand.builder().
                    id(brandDto.getBrandId()).
                    name(brandDto.getName())
                    .build();
            brandService.updateBrand(brand);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }
    }
}
