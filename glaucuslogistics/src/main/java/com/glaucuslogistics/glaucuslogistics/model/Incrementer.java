package com.glaucuslogistics.glaucuslogistics.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Incrementer {

    @Id
    private Integer id;

    public Incrementer(){
        this.id = 0;
    }
}
