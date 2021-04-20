package com.shatalova.hr_department.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subdivision")
public class Subdivision extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
