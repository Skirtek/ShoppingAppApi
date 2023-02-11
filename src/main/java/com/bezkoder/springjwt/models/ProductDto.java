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
public class ProductDto {
    private UUID hash;
    private String name;
    private double price;
    private String url;
    private String category;
    private String manufacturer;

    public static ProductDto fromEntity(Product entity) {
        return ProductDto
                .builder()
                .hash(entity.getHash())
                .name(entity.getName())
                .price(entity.getPrice())
                .url(entity.getUrl())
                .category(entity.getCategory())
                .manufacturer(entity.getManufacturer())
                .build();
    }
}
