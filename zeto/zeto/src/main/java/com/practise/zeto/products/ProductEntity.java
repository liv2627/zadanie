package com.practise.zeto.products;

import com.practise.zeto.buyers.BuyerEntity;
import com.practise.zeto.global.GlobalEntity;
import com.practise.zeto.sellers.SellerEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity extends GlobalEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;


    private String name;

    private Double price;

    private Integer amount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "seller_id")
    SellerEntity sellerEntity;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "buyer_id")
    BuyerEntity buyerEntity;

    public ProductDTO toDTO() {
        return ProductDTO.builder()
                .name(this.name)
                .price(this.price)
                .amount(this.amount)
                .sellerId(this.sellerEntity.getId())
                .buyerId(this.buyerEntity.getId())
                .build();
    }
}