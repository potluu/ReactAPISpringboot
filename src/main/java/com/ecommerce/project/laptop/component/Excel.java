package com.ecommerce.project.laptop.component;

import com.ecommerce.project.laptop.common.EKeyword;
import com.ecommerce.project.laptop.entitty.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@AllArgsConstructor
@Data
@Builder
@RequiredArgsConstructor
public class Excel {
    private String TitleSheet;
    private String titleTable;
    private String url;
    private String typeObject;
    private String nameFile;
    private String[] header;
    private List<Object> list;

    public void writeTitle(SXSSFSheet sheet){
        int cells=this.header.length;
        EKeyword key[] =EKeyword.values();
        String mergedRegion="A1:"+key[cells-1].name()+cells;
        sheet.addMergedRegion(CellRangeAddress.valueOf(mergedRegion));
        Row title=sheet.createRow(0);
        Cell tCell=title.createCell(0);
        tCell.setCellValue(this.titleTable);
    }
    public void writeHeader(SXSSFSheet sheet) {
        Row header = sheet.createRow(1);
        for (int i = 0; i < this.header.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(this.header[i]);
        }
    }
    public void writeData(SXSSFSheet sheet) {
        int countRow = 2;
        for (Object object : this.getList()) {
            Row cells = sheet.createRow(countRow++);
            write(cells);
        }

    }
    public void write(Row cells) {

    }
}
