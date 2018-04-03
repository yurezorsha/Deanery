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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findByIdTeach", query = "SELECT t FROM Teacher t WHERE t.idTeach = :idTeach")
    , @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT t FROM Teacher t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "Teacher.findBySurName", query = "SELECT t FROM Teacher t WHERE t.surName = :surName")
    , @NamedQuery(name = "Teacher.findByPatronymic", query = "SELECT t FROM Teacher t WHERE t.patronymic = :patronymic")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_teach")
    private Integer idTeach;
    @Size(max = 45)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "SurName")
    private String surName;
    @Size(max = 45)
    @Column(name = "Patronymic")
    private String patronymic;
    @OneToMany(mappedBy = "teacher")
    private Collection<Subject> subjectCollection;

    public Teacher() {
    }

    public Teacher(Integer idTeach) {
        this.idTeach = idTeach;
    }

    public Integer getIdTeach() {
        return idTeach;
    }

    public void setIdTeach(Integer idTeach) {
        this.idTeach = idTeach;
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

    @XmlTransient
    public Collection<Subject> getSubjectCollection() {
        return subjectCollection;
    }

    public void setSubjectCollection(Collection<Subject> subjectCollection) {
        this.subjectCollection = subjectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTeach != null ? idTeach.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.idTeach == null && other.idTeach != null) || (this.idTeach != null && !this.idTeach.equals(other.idTeach))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idTeach +" " +surName+ " "+ firstName+" "+patronymic;
    }
    
    public String getFIO() {
        return  surName+ " "+ firstName+" "+patronymic;
    }
    
}
