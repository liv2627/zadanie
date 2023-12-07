
package com.practise.zeto.sellers;

import com.practise.zeto.products.ProductEntity;
import lombok.Builder;

import java.util.List;

public record SellerDTO(String companyName, String address, List<ProductEntity> products)
{
    @Builder
    public SellerDTO {};
}