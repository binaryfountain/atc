package com.company;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aircraft {

    @Id
    private int id;
    private String type;
    private String size;

    public int getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
