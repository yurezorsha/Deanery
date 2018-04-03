/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
public class StudFacade extends AbstractFacade<Stud> {
     
    
    @PersistenceContext(unitName = "DeaneryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
        
    }
    public Collection<Stud> getIndebtStud(){
      Query q2=em.createQuery("SELECT s From Stud s Where s in(Select m.student From Mark m Where m.mark<4 )");
      Collection<Stud> st= q2.getResultList(); 
      System.out.print(st);
      return st;
    }
    public void Course(){
  
    Query q=em.createQuery("UPDATE Stud s SET s.course = s.course+1 Where s.course<>5 and s in(Select m.student From Mark m Where m.mark>=4 )");
    q.executeUpdate();
    
    }

    public StudFacade() {
        super(Stud.class);
    }
    
    
    
}
