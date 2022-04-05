package com.example.vnotes;

public class Course {
    int image;
    String name;
    int forwardImage;

    public Course(int image,String name,int forwardImage) {
        this.image = image;
        this.name = name;
        this.forwardImage = forwardImage;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForwardImage() {
        return forwardImage;
    }

    public void setForwardImage(int forwardImage) {
        this.forwardImage = forwardImage;
    }
}
