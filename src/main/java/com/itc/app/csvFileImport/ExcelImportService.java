package com.itc.app.excelFileImport;

import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itc.app.Repository.productRepositories;
import com.itc.app.productEntity.productEntity;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ExcelImportService {

    @Autowired
    private productRepositories productRepositories;

    public void importExcel(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

            // Skip the header row
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null)
                    continue;

                productEntity entity = new productEntity(); // Change to your actual entity class

                // Map Excel columns to entity fields
                entity.setProductId((long) row.getCell(0).getNumericCellValue());
                entity.setproductCategory(row.getCell(1).getStringCellValue());
                entity.setProductName(row.getCell(2).getStringCellValue());
                entity.setProductUnitPrice((int) row.getCell(3).getNumericCellValue());
                entity.setProductPrice((int) row.getCell(4).getNumericCellValue());
                entity.setProductURL(row.getCell(5).getStringCellValue());
                entity.setProductQuantity((int) row.getCell(6).getNumericCellValue());
                entity.setProductDescription(row.getCell(7).getStringCellValue());

                productRepositories.save(entity);
            }
        }
    }
}
