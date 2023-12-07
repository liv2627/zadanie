package com.practise.zeto.buyers;
import com.practise.zeto.products.ProductEntity;
import lombok.Builder;

import java.util.List;
public record BuyerDTO(String firstName, String lastName, String email, String password, List<ProductEntity> products) {
    @Builder
    public BuyerDTO {};
}
