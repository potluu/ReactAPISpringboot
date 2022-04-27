package com.ecommerce.project.laptop.utils;

import com.ecommerce.project.laptop.component.Excel;
import com.ecommerce.project.laptop.dto.ProductDto;
import com.ecommerce.project.laptop.services.AccountService;
import com.ecommerce.project.laptop.services.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import net.bytebuddy.asm.Advice;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class FileUtils {
private static final  String URL ="src/main/resources/static/";
@Autowired
private  ProductServiceImpl productService;

    public  void exportExcel(Excel excel, String key) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        String path = excel.getUrl() + "/" + excel.getNameFile();
        SXSSFSheet sheet=workbook.createSheet(excel.getTitleSheet());
        excel.writeHeader(sheet);
        excel.writeTitle(sheet);
        int index=2;
        if(key.equals("PRODUCT")){
            List<ProductDto> productDtos= new ArrayList<>();
           productService.getAllProduct().forEach(product ->
            {
                productDtos.add(new ProductDto(product));
           });
           for(ProductDto p:productDtos){
               Row row=sheet.createRow(index++);
               p.writeData(row);
           }
        }

        saveFileEcxel(workbook,excel.getUrl());

    }
    public static void saveFileEcxel(SXSSFWorkbook workbook, String url) {
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("D:/test.xlsx"));
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.debug("error" + e.getMessage());
        } catch (IOException e) {
            log.debug("error" + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void saveImage(MultipartFile multipartFile, String type) {
        File fileRoot = new File("src\\main\\resources\\static\\" + type);
        if (!fileRoot.exists()) {
            fileRoot.mkdirs();
        }
        String rootURL = fileRoot.getAbsolutePath() + "\\" + multipartFile.getOriginalFilename();
        try {
            File upload = new File(rootURL);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(upload));
            bos.write(multipartFile.getBytes());
            bos.close();
        } catch (Exception e) {
            log.debug("error save image" + e.getMessage());
            e.printStackTrace();
        }


    }
    public static void deleteFile(String name){
    File file = new File(URL+name);
    if(file.exists()){
        try {
        file.delete();
        }catch (BufferOverflowException bosf){
            log.debug("error BufferedInputStream get file"+bosf.getMessage());
        }catch (Exception e){
            log.debug("errot exption "+e.getMessage());
        }
    }
    }
}
