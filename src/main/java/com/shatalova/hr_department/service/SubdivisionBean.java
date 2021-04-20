package com.shatalova.hr_department.service;


import com.shatalova.hr_department.entity.Subdivision;
import com.shatalova.hr_department.records.SubdivisionRecord;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class SubdivisionBean {

    @EJB
    ServiceDAO serviceDAO;

    public List<SubdivisionRecord> getAllSubdivision(){
        return serviceDAO.findAll(Subdivision.class)
                .stream()
                .map(subdivision -> new SubdivisionRecord(subdivision.getId(), subdivision.getName()))
                .collect(Collectors.toList());
    }

    public SubdivisionRecord getSubdivisionById(Long id){
        Subdivision subdivision = serviceDAO.findById(id, Subdivision.class);
        return new SubdivisionRecord(subdivision.getId(), subdivision.getName());
    }

    public void createSubdivision(SubdivisionRecord subdivisionRecord){
        Subdivision subdivision = new Subdivision();
        subdivision.setName(subdivisionRecord.getName());
        serviceDAO.persist(subdivision);
    }

    public void updateSubdivision(SubdivisionRecord subdivisionRecord){
        Subdivision subdivision = new Subdivision();
        subdivision.setId(subdivisionRecord.getId());
        subdivision.setName(subdivisionRecord.getName());
        serviceDAO.merge(subdivision);
    }

    public void deleteSubdivision(List<Long> ids){
        serviceDAO.removeByIds(ids, Subdivision.class);
    }
}
