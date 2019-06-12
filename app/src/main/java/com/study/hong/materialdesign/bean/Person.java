package com.study.hong.materialdesign.bean;

/**
 * Created by hong on 2019/6/12.
 */

public class Person {
    private String name;
    private int imgId;

    public Person(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }
}
