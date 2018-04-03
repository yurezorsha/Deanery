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
@Table(name = "subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s")
    , @NamedQuery(name = "Subject.findByIdSubj", query = "SELECT s FROM Subject s WHERE s.idSubj = :idSubj")
    , @NamedQuery(name = "Subject.findByName", query = "SELECT s FROM Subject s WHERE s.name = :name")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_subj")
    private Integer idSubj;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @JoinColumn(name = "Teacher", referencedColumnName = "id_teach")
    @ManyToOne
    private Teacher teacher;
    @OneToMany(mappedBy = "subject")
    private Collection<Mark> markCollection;

    public Subject() {
    }

    public Subject(Integer idSubj) {
        this.idSubj = idSubj;
    }

    public Integer getIdSubj() {
        return idSubj;
    }

    public void setIdSubj(Integer idSubj) {
        this.idSubj = idSubj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
        hash += (idSubj != null ? idSubj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.idSubj == null && other.idSubj != null) || (this.idSubj != null && !this.idSubj.equals(other.idSubj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idSubj + " "+ name;
    }
    
}
