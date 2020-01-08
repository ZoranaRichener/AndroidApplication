package com.example.ladyzorzy.peakselapp.data;

public class GamesItemHome {

    private String category_name,ID,title,image,feautred_image,category,link;

    public GamesItemHome() {
    }

    public GamesItemHome(String category_name, String ID, String title, String image, String feautred_image, String category, String link) {
        this.category_name = category_name;
        this.ID = ID;
        this.title = title;
        this.image = image;
        this.feautred_image = feautred_image;
        this.category = category;
        this.link = link;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFeautred_image() {
        return feautred_image;
    }

    public void setFeautred_image(String feautred_image) {
        this.feautred_image = feautred_image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
