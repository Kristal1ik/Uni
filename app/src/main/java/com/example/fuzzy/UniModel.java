package com.example.fuzzy;

public class UniModel {
    String name;
    String pr;
    int image;
    int gal1, gal2, gal3;
    String description;
    public UniModel(String name, String pr, int image, String description, int gal1,
                    int gal2, int gal3){
        this.name = name;
        this.pr = pr;
        this.image = image;
        this.description = description;
        this.gal1 = gal1;
        this.gal2 = gal2;
        this.gal3 = gal3;
    }

    public String getName() {
        return name;
    }
    public String getPr() {
        return pr;
    }
    public int getImage() {
        return image;
    }
    public String getDescription() {return description;}
    public int getGal1() {
        return gal1;
    }
    public int getGal2() {return gal2;}
    public int getGal3() {
        return gal3;
    }
}


