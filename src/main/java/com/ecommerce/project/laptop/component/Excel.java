package com.ecommerce.project.laptop.component;

import com.ecommerce.project.laptop.common.EKeyword;
import com.ecommerce.project.laptop.dto.ProductDto;
import lombok.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Excel {
    public final static int INDEX_COLUMN =1;
    public final static int INDEX_CELLS =1;
    private String titleSheet;
    private String titleTable;
    private String url;
    private String nameFile;
    private String[] header;

    public abstract void writeData(Row cells);
    public void writeTitle(SXSSFSheet sheet){
        Excel excel = new ProductDto();
        int cells=this.header.length;
        EKeyword key[] =EKeyword.values();
        String mergedRegion="A1:"+key[cells-1].name()+INDEX_CELLS;
        sheet.addMergedRegion(CellRangeAddress.valueOf(mergedRegion));
        Row title=sheet.createRow(0);
        Cell tCell=title.createCell(0);
        tCell.setCellValue(this.titleTable);
    }
    public void writeHeader(SXSSFSheet sheet) {
        Row header = sheet.createRow(INDEX_COLUMN);
        for (int i = 0; i < this.header.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(this.header[i]);
        }

    }
}
