package com.shatalova.hr_department.api;


import com.shatalova.hr_department.records.OrganizationRecord;
import com.shatalova.hr_department.service.OrganizationBean;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("/organization")
public class OrganizationApi {
    String JNDI_NAME = "organization";

    @EJB
    OrganizationBean organizationBean;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<OrganizationRecord> getOrganization(@Context HttpServletRequest request, @Context HttpServletResponse response){
        return organizationBean.getAllOrganization();
    }

    @DELETE
    @Path("/delete")
    public void deleteOrganization(@Context HttpServletRequest request,List<Long> ids){
        organizationBean.deleteOrganization(ids);
    }

    @POST
    @Path("/")
    public void insertOrganization(@Context HttpServletRequest request, OrganizationRecord record){
        organizationBean.createOrganization(record);
    }

    @PUT
    @Path("/update")
    public void updateOrganization(@Context HttpServletRequest request, OrganizationRecord record){
        organizationBean.updateOrganization(record);
    }
}
