package com.shatalova.hr_department.records;


public class OrganizationRecord extends BaseRecord {

    private static final long serialVersionUID = 1L;

    private PositionRecord position;

    private SubdivisionRecord subdivision;

    private EmployeeRecord employee;

    private Double salary;

    public OrganizationRecord(){

    }

    public PositionRecord getPosition() {
        return position;
    }

    public void setPosition(PositionRecord position) {
        this.position = position;
    }

    public SubdivisionRecord getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(SubdivisionRecord subdivision) {
        this.subdivision = subdivision;
    }

    public EmployeeRecord getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeRecord employee) {
        this.employee = employee;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
