package com.shatalova.hr_department.service;

import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Stateless
public class ServiceDAO extends AbstractBeanService implements Serializable {

    public <T> void remove(@NotNull T t) {
        em.remove(t);
    }

    public <T> void removeById(@NotNull Long id, Class<T> clazz) {
        em.createQuery("delete from "+ getEntityName(clazz) + " e where e.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public <T> void removeByIds(@NotNull List<Long> ids, Class<T> clazz) {
        em.createQuery("delete from "+ getEntityName(clazz) + " e where e.id in (:ids)")
                .setParameter("ids", ids)
                .executeUpdate();
    }

    public <T> void persist(@NotNull T t) {
        em.persist(t);
    }

    @NotNull
    public <T> T merge(@NotNull T t) {
        return Optional.ofNullable(em.merge(t))
                .orElseThrow(() -> new RuntimeException("EntityManager returned null on merge()"));
    }

    public <T> T findById(Long id, Class<T> clazz){
        return (T) em.createQuery("select e from " + getEntityName(clazz) + " e").getSingleResult();
    }

    public <T> List<T> findAll (Class<T> clazz){
        return em.createQuery("select e from " + getEntityName(clazz) + " e").getResultList();
    }

    public <T> String getEntityName(@org.jetbrains.annotations.NotNull @NotNull Class<T> clazz) {
        return clazz.getSimpleName();
    }
}
