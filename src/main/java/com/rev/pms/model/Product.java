package com.rev.pms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
//@Component
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int qoh;
    private int price;
    private int userId;

    public Product(){
        System.out.println("Product object created");
    }

    public String displayMessage(){
       return "This message is coming from product class";
    }

    @ManyToOne
    @JoinColumn()
    private User user;
}
