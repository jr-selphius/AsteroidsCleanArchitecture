package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model;

import com.google.gson.annotations.Expose;

public class Links {

    @Expose
    private String next;
    @Expose
    private String prev;
    @Expose
    private String self;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }
}
