package com.shatalova.hr_department.api;

import com.shatalova.hr_department.records.PositionRecord;
import com.shatalova.hr_department.records.ReportRecord;
import com.shatalova.hr_department.service.AbstractBeanService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.util.List;
import java.util.stream.Collectors;

@Path("/report")
@Produces("application/json")
public class ReportApi extends AbstractBeanService {

    @GET
    @Path("/")
    @Produces("application/json")
    public List<ReportRecord> getPosition(@Context HttpServletRequest request, @Context HttpServletResponse response){
        List<Object[]> record =  em.createNativeQuery("select s.name," +
                " sum (IIF(e1.sex = 'м', o.salary, 0)) salaryWomen," +
                " sum (IIF(e1.sex = 'ж', o.salary, 0)) salaryMen\n" +
                "from organization o\n" +
                "left join employee e1 on e1.id = o.employee_id\n" +
                "left join subdivision s on s.id = o.subdivision_id\n" +
                "group by s.name")
                .getResultList();
        return record.stream().map(r ->  new ReportRecord(
                (String) r[0],
                (Double)r[1],
                (Double)r[2]))
                .collect(Collectors.toList());
    }
}
