package com.shatalova.hr_department.api;


import com.shatalova.hr_department.records.EmployeeRecord;
import com.shatalova.hr_department.service.EmployeeBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;


@Stateless
@Path("/employee")
public class EmployeeApi  {

    String JNDI_NAME = "employee";

    @EJB
    EmployeeBean employeeBean;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<EmployeeRecord> getEmployee(@Context HttpServletRequest request, @Context HttpServletResponse response){
        return employeeBean.getAllEmployee();
    }

    @DELETE
    @Path("/delete")
    public void deleteEmployee(@Context HttpServletRequest request, List<Long> ids){
        employeeBean.deleteEmployee(ids);
    }

    @POST
    @Path("/")
    public void insertEmployee(@Context HttpServletRequest request, EmployeeRecord employeeRecord){
        employeeBean.createEmployee(employeeRecord);
    }

    @POST
    @Path("/update")
    public void updateEmployee(@Context HttpServletRequest request, EmployeeRecord employeeRecord){
        employeeBean.updateEmployee(employeeRecord);
    }

}
