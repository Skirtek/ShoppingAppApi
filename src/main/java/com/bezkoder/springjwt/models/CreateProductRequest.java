package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    private String name;
    private String category;
    private double price;
    private String url;
    private String manufacturer;

    public static Product toEntity(CreateProductRequest request) {
        return Product
                .builder()
                .hash(UUID.randomUUID())
                .name(request.getName())
                .price(request.getPrice())
                .url(request.getUrl())
                .category(request.getCategory())
                .manufacturer(request.getManufacturer())
                .build();
    }
}
