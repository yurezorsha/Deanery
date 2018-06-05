/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author HP
 */
public interface IFind {
    public String prepareList(); 
    public String prepareEdit(); 
    public String prepareView(); 
    public void prepareDestroy(); 
    public void setCurrentself(Object o); 
    
}
