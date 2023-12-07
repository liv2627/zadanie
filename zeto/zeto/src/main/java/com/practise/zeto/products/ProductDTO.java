package com.practise.zeto.products;

import lombok.Builder;


public record ProductDTO(String name, Double price, Integer amount, Long sellerId, Long buyerId) {
    @Builder
    public ProductDTO {};
}
