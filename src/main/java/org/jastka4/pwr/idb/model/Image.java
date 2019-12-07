package org.jastka4.pwr.idb.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long id;

    @Column(name = "name")
    @NotNull(message = "*Name cannot be empty")
    private String name;

    @Column(name = "type")
    @NotNull(message = "*Type cannot be empty")
    private String type;

    @Column(name = "alternative")
    private String alternative;

    @Column(name = "product_id")
    private int productId;

    public String getUrl() {
        return "/images/products/" + productId + "/" + name + "." + type;
    }
}
