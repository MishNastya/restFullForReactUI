package com.shatalova.hr_department.records;

public class PositionRecord extends BaseRecord {

    private static final long serialVersionUID = 1L;

    private String name;

    public PositionRecord() {

    }

    public PositionRecord(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
