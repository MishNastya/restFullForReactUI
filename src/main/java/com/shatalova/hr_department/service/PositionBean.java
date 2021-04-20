package com.shatalova.hr_department.service;

import com.shatalova.hr_department.entity.Position;
import com.shatalova.hr_department.records.PositionRecord;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class PositionBean {

    @EJB
    ServiceDAO serviceDAO;

    public List<PositionRecord> getAllPosition(){
        return serviceDAO.findAll(Position.class)
                .stream()
                .map(position -> new PositionRecord(position.getId(), position.getName()))
                .collect(Collectors.toList());
    }

    public PositionRecord getPositionById(Long id){
        Position position = serviceDAO.findById(id, Position.class);
        return new PositionRecord(position.getId(), position.getName());
    }

    public void createPosition(PositionRecord positionRecord){
        Position position = new Position();
        position.setName(positionRecord.getName());
        serviceDAO.persist(position);
    }

    public void updatePosition(PositionRecord positionRecord){
        Position position = serviceDAO.findById(positionRecord.getId(), Position.class);
        position.setName(positionRecord.getName());
        serviceDAO.merge(position);
    }

    public void deletePosition(List<Long> ids){
        serviceDAO.removeByIds(ids, Position.class);
    }

}
