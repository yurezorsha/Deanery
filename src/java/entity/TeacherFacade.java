/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
public class TeacherFacade extends AbstractFacade<Teacher> {

    @PersistenceContext(unitName = "DeaneryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeacherFacade() {
        super(Teacher.class);
    }
    
    public List<Teacher> FindTeacher(String findStr){
        Query sel = em.createQuery("FROM Teacher s WHERE s.firstName LIKE :findStr or s.surName LIKE :findStr"); 
        sel.setParameter("findStr", "%"+findStr+"%"); 
        System.out.println(sel.getResultList());
        return sel.getResultList();
    }
}
