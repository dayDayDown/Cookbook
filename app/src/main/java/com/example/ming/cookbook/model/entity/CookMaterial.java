package com.example.ming.cookbook.model.entity;

/**
 * Created by 17111862 on 2018/3/5.
 */

public class CookMaterial extends BaseEntity {
    private String name;
    private String amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
