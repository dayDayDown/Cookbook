package com.example.ming.cookbook.model.entity;

import java.util.List;

/**
 * Created by 17111862 on 2018/3/5.
 */

public class CookDetailEntity extends BaseEntity {
    private String id;
    private String name;
    private String thumbnail;
    private List<String> ctgIds;
    private List<CookMaterial> materials;
    private List<CookRecipeStep> steps;
    private String authorName;
    private String authorId;
    private String authorImg;
    private String summary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getCtgIds() {
        return ctgIds;
    }

    public void setCtgIds(List<String> ctgIds) {
        this.ctgIds = ctgIds;
    }

    public List<CookMaterial> getMaterials() {
        return materials;
    }

    public void setMaterials(List<CookMaterial> materials) {
        this.materials = materials;
    }

    public List<CookRecipeStep> getSteps() {
        return steps;
    }

    public void setSteps(List<CookRecipeStep> steps) {
        this.steps = steps;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
