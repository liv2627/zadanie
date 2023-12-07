package com.practise.zeto.buyers;

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
@Table(name="buyers")
@Setter
@Getter
@NoArgsConstructor
public class BuyerEntity extends GlobalEntity {

    private String firstName;
    private  String lastName;
    private  String email;

    private String password;

    @OneToMany(mappedBy = "buyerEntity", fetch = LAZY)
        private List<ProductEntity> products;
    public BuyerDTO toDTO() {
        return BuyerDTO.builder()
                .password(this.password)
                .email(this.email)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .products(this.products)
                .build();
    }
}
