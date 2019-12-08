package org.jastka4.pwr.idb.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private int id;
    private String code;
    private String name;
    private String description;
    private int parentCategory;
}
