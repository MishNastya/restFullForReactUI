package com.shatalova.hr_department.records;

import java.time.LocalDate;


public class EmployeeRecord extends BaseRecord {
    private static final long serialVersionUID = 1L;

    private String lastName;

    private String middleName;

    private String firstName;

    private String sex;

    private LocalDate birthday;

    public EmployeeRecord() {
    }

    public EmployeeRecord(Long id,
                          String lastName,
                          String middleName,
                          String firstName ,
                          String sex,
                          LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
        this.birthday = birthday;
    }


    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
