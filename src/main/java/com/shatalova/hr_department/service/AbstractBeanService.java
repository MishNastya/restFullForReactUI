package com.shatalova.hr_department.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractBeanService {

    @PersistenceContext(unitName = "hr_department")
    protected EntityManager em;
}
