package com.capstone.rahul.exity10;


/**
 * Created by Sagar on 05-04-2018.
 */

public class DietPlanModel {
    String title;
    String body;
    int image;

    public DietPlanModel(String title, String body, int image) {
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getbody() {
        return body;
    }
    public int getImage() {
        return image;
    }
}
