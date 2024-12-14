package com.itc.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
// import com.itc.app.excelFileImport.ExcelImportService;

import com.itc.app.Dto.productDto;
import com.itc.app.csvFileImport.ExcelImportService;
// import com.itc.app.csvFileImport.csvImport;
import com.itc.app.service.productService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin({ "https://itc-order-app.onrender.com", "**" })
public class productController {
    @Autowired
    public productService ProductService;

    @Autowired
    private ExcelImportService excelImportService;

    @PostMapping("/upload")
    @CrossOrigin(origins = "https://itc-order-app.onrender.com")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            excelImportService.importExcel(file);
            return new ResponseEntity<>("Excel file uploaded and data saved successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error uploading Excel file: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "https://itc-order-app.onrender.com")
    @PostMapping
    public ResponseEntity<?> createNewProduct(@RequestBody productDto ProductDto) {
        productDto savedProduct = ProductService.createNewProduct(ProductDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "https://itc-order-app.onrender.com")
    @GetMapping("{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long ProductId) {
        productDto ProductDto = ProductService.getProductById(ProductId);
        return ResponseEntity.ok(ProductDto);
    }

    @CrossOrigin(origins = "https://itc-order-app.onrender.com")
    @GetMapping()
    public ResponseEntity<List<productDto>> getAllProducts() {
        List<productDto> Product = ProductService.getAllProduct();
        return ResponseEntity.ok(Product);
    }
}
