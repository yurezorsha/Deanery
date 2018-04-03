/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "stud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stud.findAll", query = "SELECT s FROM Stud s")
    , @NamedQuery(name = "Stud.findByIdStud", query = "SELECT s FROM Stud s WHERE s.idStud = :idStud")
    , @NamedQuery(name = "Stud.findByFirstName", query = "SELECT s FROM Stud s WHERE s.firstName = :firstName")
    , @NamedQuery(name = "Stud.findBySurName", query = "SELECT s FROM Stud s WHERE s.surName = :surName")
    , @NamedQuery(name = "Stud.findByPatronymic", query = "SELECT s FROM Stud s WHERE s.patronymic = :patronymic")
    , @NamedQuery(name = "Stud.findByCourse", query = "SELECT s FROM Stud s WHERE s.course = :course")})
public class Stud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_stud")
    private Integer idStud;
    @Size(max = 45)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "SurName")
    private String surName;
    @Size(max = 45)
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "Course")
    private Integer course;
    @JoinColumn(name = "Gr", referencedColumnName = "id_group")
    @ManyToOne
    private Gr gr;
    @OneToMany(mappedBy = "student")
    private Collection<Mark> markCollection;

    public Stud() {
    }

    public Stud(Integer idStud) {
        this.idStud = idStud;
    }

    public Integer getIdStud() {
        return idStud;
    }

    public void setIdStud(Integer idStud) {
        this.idStud = idStud;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Gr getGr() {
        return gr;
    }

    public void setGr(Gr gr) {
        this.gr = gr;
    }

    @XmlTransient
    public Collection<Mark> getMarkCollection() {
        return markCollection;
    }

    public void setMarkCollection(Collection<Mark> markCollection) {
        this.markCollection = markCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStud != null ? idStud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stud)) {
            return false;
        }
        Stud other = (Stud) object;
        if ((this.idStud == null && other.idStud != null) || (this.idStud != null && !this.idStud.equals(other.idStud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idStud +" "+surName+" " +firstName+ " "+ patronymic;
    }
    
    public String getFIO() {
        return surName+" "+firstName+" "+ patronymic;
    }
    
    
}
