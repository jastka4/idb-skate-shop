package org.jastka4.pwr.idb.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column(name = "item_name")
    @NotEmpty(message = "*Name of the item")
    private String name;

    @Column(name = "item_desc")
    @NotEmpty(message = "*Description of the item")
    private String description;

    @Column(name = "items_amount")
    private int amount;

    @Column(name = "item_price")
    @NotEmpty(message = "*Price")
    private float price;
//
//    @Column(name = "item_category")
//    private String category;

    @ManyToOne
    @JoinColumn(name = "cart_id", foreignKey = @ForeignKey(name = "cart_id_fk"))
    private Cart cart;

}
