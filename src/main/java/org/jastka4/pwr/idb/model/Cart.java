package org.jastka4.pwr.idb.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "value")
    private BigDecimal value;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "item_carts", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    public Cart() {
        value = BigDecimal.valueOf(0);
    }
}
