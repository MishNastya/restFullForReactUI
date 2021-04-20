package com.shatalova.hr_department.api;

import com.shatalova.hr_department.records.PositionRecord;
import com.shatalova.hr_department.service.PositionBean;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("/position")
public class PositionApi {
    String JNDI_NAME = "position";

    @EJB
    PositionBean positionBean;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<PositionRecord> getPosition(@Context HttpServletRequest request, @Context HttpServletResponse response){
        return positionBean.getAllPosition();
    }

    @DELETE
    @Path("/delete")
    public void deletePosition(@Context HttpServletRequest request, List<Long> ids){
        positionBean.deletePosition(ids);
    }

    @POST
    @Path("/")
    public void insertPosition(@Context HttpServletRequest request, PositionRecord record){
        positionBean.createPosition(record);
    }

    @POST
    @Path("/update")
    public void updatePosition(@Context HttpServletRequest request, PositionRecord record){
        PositionRecord position = new PositionRecord();
        positionBean.updatePosition(position);
    }

}
