package com.practise.zeto.models;
import java.sql.Timestamp;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    private Long id;

    private String name;

    private Double price;
    private Date dats = new Date();
   private Timestamp created_at = new Timestamp(dats.getTime());
    private int amount;



    public Product(String name, Double price){
        this.name = name;
        this.price = price;
        this.created_at = created_at;
        this.amount=amount;
        this.dats=dats;

    }
}
