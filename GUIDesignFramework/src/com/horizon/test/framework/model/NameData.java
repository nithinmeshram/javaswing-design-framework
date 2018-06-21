package com.horizon.test.framework.model;

public class NameData implements BasicDataModel {

    private static final long serialVersionUID = 5583130086376137920L;

    private String            name;


    public NameData(String text) {

        this.name = text;
    }


    public String getName() {

        return this.name;
    }


    public void setName(String name) {

        this.name = name;
    }


    @Override
    public String toString() {

        return "NameData [name=" + this.name + "]";
    }

}
