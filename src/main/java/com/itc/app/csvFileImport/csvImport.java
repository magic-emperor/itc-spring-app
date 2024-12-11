package com.itc.app.csvFileImport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itc.app.Repository.productRepositories;
import com.itc.app.productEntity.productEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class csvImport {

    @Autowired
    private productRepositories productRepositories;

    public void importCsv(MultipartFile file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(reader);
            for (CSVRecord record : records) {
                productEntity entity = new productEntity(); // Change to your actual entity class
                entity.setProductId(Long.parseLong(record.get("productId")));
                entity.setproductCategory(record.get("productCategory"));
                entity.setProductName(record.get("productName"));
                entity.setProductUnitPrice(Integer.parseInt(record.get("productUnitPrice")));
                entity.setProductPrice(Integer.parseInt(record.get("productPrice")));
                entity.setProductURL(record.get("productUrl"));
                entity.setProductQuantity(Integer.parseInt(record.get("productQuantity")));
                entity.setProductDescription(record.get("productDescription"));

                productRepositories.save(entity);
            }
        }
    }
}




