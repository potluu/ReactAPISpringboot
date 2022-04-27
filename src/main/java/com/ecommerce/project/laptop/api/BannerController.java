package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.entitty.Banner;
import com.ecommerce.project.laptop.services.BannerServiceImpl;
import com.ecommerce.project.laptop.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/api/v12")
@RequiredArgsConstructor
public class BannerController {

    private final BannerServiceImpl bannerService;
    private final FileUtils fileUtils;


    /*

     */
    @GetMapping(value = "/banners")
    public ResponseEntity<?> getAllBanner() {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.asMediaType(MediaType.APPLICATION_JSON))
                .body(bannerService.findAll());
    }

    /*

     */
    @GetMapping("/banner/{id}")
    public ResponseEntity<?> getBannerById(@PathVariable("id") long id) {
        return new ResponseEntity<>(bannerService.getById(id), HttpStatus.OK);
    }

    /*

     */
    @PostMapping(value = "/banner",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> saveBanner(@RequestPart Banner banner, @RequestPart
            MultipartFile multipartFile) {
        if(!multipartFile.isEmpty()){
            banner.setLink_images(multipartFile.getOriginalFilename());
            bannerService.save(banner);
            fileUtils.saveImage(multipartFile,"banner");

            return ResponseEntity.status(HttpStatus.OK).body(true);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not null data file");
        }
    }
    /*

     */

    @DeleteMapping("/banner/{id}")
    public ResponseEntity<?> deleteBannerById(@PathVariable long id) {
        boolean check = bannerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(check);
    }

    /*

     */
    @PutMapping("/banner")
    public ResponseEntity<?> updateBanner(@ModelAttribute(name = "banner") Banner banner) {
        bannerService.updateBanner(banner);
        return ResponseEntity.status(HttpStatus.OK).body(true);

    }

}
