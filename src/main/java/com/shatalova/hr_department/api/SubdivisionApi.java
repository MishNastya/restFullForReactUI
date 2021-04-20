package com.shatalova.hr_department.api;


import com.shatalova.hr_department.records.SubdivisionRecord;
import com.shatalova.hr_department.service.SubdivisionBean;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("/subdivision")
public class SubdivisionApi {
    String JNDI_NAME = "subdivision";

    @EJB
    SubdivisionBean subdivisionBean;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<SubdivisionRecord> getSubdivision(@Context HttpServletRequest request, @Context HttpServletResponse response){
        return subdivisionBean.getAllSubdivision();
    }

    @DELETE
    @Path("/delete")
    public void deleteSubdivision(@Context HttpServletRequest request, List<Long> ids){
        subdivisionBean.deleteSubdivision(ids);
    }

    @POST
    @Path("/")
    public void insertSubdivision(@Context HttpServletRequest request, SubdivisionRecord subdivisionRecord){
       subdivisionBean.createSubdivision(subdivisionRecord);
    }

    @PUT
    @Path("/update")
    public void updateSubdivision(@Context HttpServletRequest request, SubdivisionRecord subdivisionRecord){
        subdivisionBean.updateSubdivision(subdivisionRecord);
    }

}
