package com.dhia.springpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

}
