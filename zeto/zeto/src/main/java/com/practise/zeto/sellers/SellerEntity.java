package com.practise.zeto.sellers;

import com.practise.zeto.global.GlobalEntity;
import com.practise.zeto.products.ProductEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "sellers")
@Getter
@Setter
@NoArgsConstructor
public class SellerEntity extends GlobalEntity {

    private String companyName;

    private String address;

    @OneToMany(mappedBy = "sellerEntity", fetch = LAZY)
    private List<ProductEntity> products;

    public SellerDTO toDTO() {
        return SellerDTO.builder()
                .address(this.address)
                .companyName(this.companyName)
                .products(this.products)
                .build();
    }

}