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


import entity.Gr;
import entity.GrController;
import entity.GrFacade;
import entity.Stud;
import entity.StudController;
import entity.StudFacade;
import entity.Subject;
import entity.SubjectController;
import entity.SubjectFacade;
import entity.Teacher;
import entity.TeacherController;
import entity.TeacherFacade;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "FindCtrl")
@SessionScoped 
public class Findctrl implements Serializable { 


@EJB private StudFacade StudFacade; 
@EJB private  GrFacade GrFacade; 
@EJB private TeacherFacade TeacherFacade; 
@EJB private SubjectFacade SubjectFacade; 
@Inject private StudController studCtrl; 
@Inject private GrController grCtrl; 
@Inject private TeacherController teacherCtrl; 
@Inject private SubjectController subjectCtrl; 

private String findStr; 
private DataModel findResult = null; 


public StudFacade getStudFacade() { 
return StudFacade; 
} 

public Findctrl() { 
} 

public void setFindStr(String findStr) { 
this.findStr = findStr; 
} 

public void setFindResult(DataModel findResult) { 
this.findResult = findResult; 
} 

public String getFindStr() { 
return findStr; 
} 

public DataModel getFindResult() { 
return findResult; 
} 

private GrFacade getGrFacade() { 
return GrFacade; 
} 

public TeacherFacade getTeacherFacade() { 
return TeacherFacade; 
} 

public SubjectFacade getSubjectFacade() { 
return SubjectFacade; 
}

public String goFind(){ 

List<FindItms> lst = new LinkedList(); 
List<Stud> stlst = getStudFacade().FindStud(findStr); 
List<Gr> glst = getGrFacade().FindGr(findStr); 
List<Teacher> tlst = getTeacherFacade().FindTeacher(findStr); 
List<Subject> sblst = getSubjectFacade().FindSubject(findStr); 

for(Stud st: stlst){ 
lst.add(new FindItms("Stud", "stud",st.getFIO() , st, studCtrl)); 
System.out.println(lst.toString()); 
} 
for(Gr g: glst){ 
lst.add(new FindItms("Group", "group", g.getName(), g, grCtrl)); 
System.out.println(lst.toString()); 
} 
for(Teacher t: tlst){ 
lst.add(new FindItms("Teacher", "teacher", t.getFIO(), t, teacherCtrl)); 
System.out.println(lst.toString()); 
} 
for(Subject sb: sblst){ 
lst.add(new FindItms("Subject", "subject", sb.getName(), sb, subjectCtrl)); 
System.out.println(lst.toString()); 
}

findResult = new ListDataModel(lst); 

return "/findList"; 
} 

public String goToList(){ 

FindItms f = (FindItms) getFindResult().getRowData(); 
String d = (f.getSite() + "/" + f.getCtrl().prepareList()); 
System.out.println(d); 
return d; 
} 

public String deleteItm(){ 

FindItms f = (FindItms) getFindResult().getRowData(); 
System.out.println("delete "+f.getTable()); 
//clientCtrl.setCurrentself(f.getObj()); 
f.getCtrl().setCurrentself(f.getObj()); 
f.getCtrl().prepareDestroy(); 
return goFind(); 
} 

public String editItm(){ 

FindItms f = (FindItms) getFindResult().getRowData(); 
f.getCtrl().setCurrentself(f.getObj()); 
System.out.println(f.getSite()); 
return f.getSite() + "/Edit"; 
} 
}
