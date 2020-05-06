package com.pcd.ecommerce.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity

public class Image {
    public Image(){}

    public Image(String name, String type, byte[] pic) {
        this.name = name;
        this.type = type;
        this.image = pic;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String type;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
