package com.shatalova.hr_department.service;

import com.shatalova.hr_department.entity.Employee;
import com.shatalova.hr_department.entity.Organization;
import com.shatalova.hr_department.entity.Position;
import com.shatalova.hr_department.entity.Subdivision;
import com.shatalova.hr_department.records.EmployeeRecord;
import com.shatalova.hr_department.records.OrganizationRecord;
import com.shatalova.hr_department.records.PositionRecord;
import com.shatalova.hr_department.records.SubdivisionRecord;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class OrganizationBean {
    @EJB
    ServiceDAO serviceDAO;

    public List<OrganizationRecord> getAllOrganization() {
        return serviceDAO.findAll(Organization.class)
                .stream()
                .map( (organization) -> {
                    SubdivisionRecord subdivisionRecord = new SubdivisionRecord(organization.getSubdivision().getId(),
                            organization.getSubdivision().getName());
                    PositionRecord positionRecord = new PositionRecord(organization.getPosition().getId(), organization.getPosition().getName());
                    EmployeeRecord employeeRecord = new EmployeeRecord();
                    employeeRecord.setFirstName(organization.getEmployee().getFirstName());
                    employeeRecord.setLastName(organization.getEmployee().getLastName());
                    employeeRecord.setMiddleName(organization.getEmployee().getMiddleName());
                    OrganizationRecord record = new OrganizationRecord();
                    record.setEmployee(employeeRecord);
                    record.setPosition(positionRecord);
                    record.setSubdivision(subdivisionRecord);
                    record.setSalary(organization.getSalary());
                    return record;
                }).collect(Collectors.toList());
    }

    public void createOrganization(OrganizationRecord organizationRecord) {
        Organization organization = new Organization();
        fillOrganization(organization, organizationRecord);
        serviceDAO.persist(organization);
    }

    public void updateOrganization(OrganizationRecord organizationRecord) {
        Organization organization = serviceDAO.findById(organizationRecord.getId(), Organization.class);
        fillOrganization(organization, organizationRecord);
        serviceDAO.persist(organization);
    }

    private Organization fillOrganization(Organization organization, OrganizationRecord organizationRecord){
        organization.setEmployee(serviceDAO.findById(organizationRecord.getEmployee().getId(), Employee.class));
        organization.setSubdivision(serviceDAO.findById(organizationRecord.getSubdivision().getId(), Subdivision.class));
        organization.setPosition(serviceDAO.findById(organizationRecord.getPosition().getId(), Position.class));
        organization.setSalary(organization.getSalary());
        return organization;
    }

    public void deleteOrganization(List<Long> ids) {
        serviceDAO.removeByIds(ids, Organization.class);
    }
}
