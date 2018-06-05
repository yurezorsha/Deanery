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
public class GrFacade extends AbstractFacade<Gr> {

    @PersistenceContext(unitName = "DeaneryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrFacade() {
        super(Gr.class);
    }
    
    public List<Gr> FindGr(String findStr){
        Query sel = em.createQuery("FROM Gr g WHERE g.name LIKE :findStr"); 
        sel.setParameter("findStr", "%"+findStr+"%"); 
        return sel.getResultList();
        
    }
    
}
