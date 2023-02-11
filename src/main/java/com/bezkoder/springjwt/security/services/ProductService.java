package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.constants.Constants;
import com.bezkoder.springjwt.models.CreateProductRequest;
import com.bezkoder.springjwt.models.Product;
import com.bezkoder.springjwt.models.ProductDto;
import com.bezkoder.springjwt.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Page<ProductDto> getAll(int page) {
        Pageable pageable = PageRequest.of(page, Constants.DefaultPageSize);

        return repository.findAll(pageable).map(ProductDto::fromEntity);
    }

    public ProductDto addProduct(CreateProductRequest product) {
        Product resultProduct = repository.save(CreateProductRequest.toEntity(product));
        return ProductDto.fromEntity(resultProduct);
    }
}
