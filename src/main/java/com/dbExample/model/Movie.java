package com.dbExample.model;

public class Movie {
    private String title;
    private int budget;
    private String homepage;

    public Movie(String title,int budget,String homepage){
        this.title=title;
        this.budget=budget;
        this.homepage=homepage;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
