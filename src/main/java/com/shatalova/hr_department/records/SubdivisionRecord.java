package com.shatalova.hr_department.records;

public class SubdivisionRecord extends BaseRecord {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubdivisionRecord(){

    }

    public SubdivisionRecord(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
