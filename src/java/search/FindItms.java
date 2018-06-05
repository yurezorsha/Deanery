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
public class FindItms { 

public FindItms(){} 

private String table; 
private String site; 
private String info; 
private Object obj; 
private IFind ctrl; 

public IFind getCtrl() { 
return ctrl; 
} 

public void setCtrl(IFind ctrl) { 
this.ctrl = ctrl; 
} 

public String getTable() { 
return table; 
} 

public String getSite() { 
return site; 
} 

public String getInfo() { 
return info; 
} 

public Object getObj() { 
return obj; 
} 

public void setTable(String table) { 
this.table = table; 
} 

public void setSite(String site) { 
this.site = site; 
} 

public void setInfo(String info) { 
this.info = info; 
} 

public void setObj(Object obj) { 
this.obj = obj; 
} 

public FindItms( String table,String site,String info,Object obj, IFind ctrl){ 
this.info = info; 
this.obj =obj; 
this.site =site; 
this.table =table; 
this.ctrl = ctrl; 
} 

@Override 
public String toString(){ 

return this.info; 
} 

}
