package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.CreateProductRequest;
import com.bezkoder.springjwt.models.ProductDto;
import com.bezkoder.springjwt.security.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/getAll")
    public ResponseEntity<Page<ProductDto>> getAll(@RequestParam Integer page) {
        return ResponseEntity.ok(service.getAll(page));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CreateProductRequest request) {
        service.addProduct(request);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
