package com.example.vitapp;

public class sliderclass {
    String description,title;
    int image;




    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public sliderclass(String description, String title, int image) {
        this.description = description;
        this.title = title;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
