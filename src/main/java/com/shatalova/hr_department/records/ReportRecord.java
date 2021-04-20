package com.shatalova.hr_department.records;

public class ReportRecord {

    private String subdivisionName;
    private Double salaryWomen;
    private Double salaryMen;

    public ReportRecord(String subdivisionName, Double salaryWomen, Double salaryMen){
        this.subdivisionName = subdivisionName;
        this.salaryWomen = salaryWomen;
        this.salaryMen = salaryMen;
    }

    public String getSubdivisionName() {
        return subdivisionName;
    }

    public void setSubdivisionName(String subdivisionName) {
        this.subdivisionName = subdivisionName;
    }

    public Double getSalaryWomen() {
        return salaryWomen;
    }

    public void setSalaryWomen(Double salaryWomen) {
        this.salaryWomen = salaryWomen;
    }

    public Double getSalaryMen() {
        return salaryMen;
    }

    public void setSalaryMen(Double salaryMen) {
        this.salaryMen = salaryMen;
    }
}
