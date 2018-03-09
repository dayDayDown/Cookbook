package com.example.ming.cookbook.model.entity;

/**
 * Created by 17111862 on 2018/3/5.
 */

public class CookRecipeStep extends BaseEntity {
    private String step;
    private String img;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
