package org.jastka4.pwr.idb.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column(name = "code")
    @NotEmpty(message = "*Code cannot be empty")
    private String code;

    @Column(name = "name")
    @NotEmpty(message = "*Name cannot be empty")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private int amount;

    @Column(name = "price")
    @NotNull(message = "*Price cannot be empty")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "productId")
    private List<Image> images;
}
