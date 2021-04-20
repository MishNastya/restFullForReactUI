package com.shatalova.hr_department.service;

import com.shatalova.hr_department.entity.Employee;
import com.shatalova.hr_department.records.EmployeeRecord;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class EmployeeBean {

    @EJB
    ServiceDAO serviceDAO;

    public List<EmployeeRecord> getAllEmployee() {
        return serviceDAO.findAll(Employee.class)
                .stream()
                .map(employee -> new EmployeeRecord(employee.getId(),
                        employee.getLastName(),
                        employee.getMiddleName(),
                        employee.getFirstName(),
                        employee.getSex(),
                        employee.getBirthday()
                )).collect(Collectors.toList());
    }

    public EmployeeRecord getEmployeeById(Long id) {
        Employee employee = serviceDAO.findById(id, Employee.class);
        return new EmployeeRecord(employee.getId(),
                employee.getLastName(),
                employee.getMiddleName(),
                employee.getFirstName(),
                employee.getSex(),
                employee.getBirthday());
    }

    public void createEmployee(EmployeeRecord employeeRecord) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRecord.getFirstName());
        employee.setLastName(employeeRecord.getLastName());
        employee.setMiddleName(employeeRecord.getMiddleName());
        employee.setSex(employeeRecord.getSex());
        employee.setBirthday(employeeRecord.getBirthday());
        serviceDAO.persist(employee);
    }

    public void updateEmployee(EmployeeRecord employeeRecord) {
        Employee employee = serviceDAO.findById(employeeRecord.getId(), Employee.class);
        employee.setFirstName(employeeRecord.getFirstName());
        employee.setLastName(employeeRecord.getLastName());
        employee.setMiddleName(employeeRecord.getMiddleName());
        employee.setSex(employeeRecord.getSex());
        employee.setBirthday(employeeRecord.getBirthday());
        serviceDAO.merge(employee);
    }

    public void deleteEmployee(List<Long> ids) {
        serviceDAO.removeByIds(ids, Employee.class);
    }

}
