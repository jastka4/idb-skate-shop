package org.jastka4.pwr.idb.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;

    @Column(name = "cart_date")
    private LocalDateTime date;

    @Column(name = "cart_value")
    private float value;

//    @Column(name = "payment_type") // cash or credit card
//    private String paymentType;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id_fk"))
    private User client;
//
//    @OneToMany
//    @JoinColumn(name = "fk_cart")
//    private List<Item> items = new ArrayList<Item>();
}
