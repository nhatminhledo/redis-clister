package com.example.redis.springbootrediscache.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "customerssss")
@Getter
@Setter
public class Customer implements Serializable {

	@Id
    @SequenceGenerator(name = "customerSeqGen", sequenceName = "customerSeq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customerSeqGen")
    private Long id;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getName_1() {
        return name_1;
    }


    public void setName_1(String name_1) {
        this.name_1 = name_1;
    }


    public String getName_2() {
        return name_2;
    }


    public void setName_2(String name_2) {
        this.name_2 = name_2;
    }


    public String getName_3() {
        return name_3;
    }


    public void setName_3(String name_3) {
        this.name_3 = name_3;
    }


    public String getName_4() {
        return name_4;
    }


    public void setName_4(String name_4) {
        this.name_4 = name_4;
    }


    @Column(name = "code", length = 20)
    private String code;

    @Column(name = "name_1")
    private String name_1;

    @Column(name = "name_2")
    private String name_2;

    @Column(name = "name_3")
    private String name_3;

    @Column(name = "name_4")
    private String name_4;


    public Customer(){}


    public Customer(Long id, String code, String name_1, String name_2, String name_3, String name_4) {
        this.id = id;
        this.code = code;
        this.name_1 = name_1;
        this.name_2 = name_2;
        this.name_3 = name_3;
        this.name_4 = name_4;
    }
}
