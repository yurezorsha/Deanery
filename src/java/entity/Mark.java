/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "mark")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mark.findAll", query = "SELECT m FROM Mark m")
    , @NamedQuery(name = "Mark.findByIdMark", query = "SELECT m FROM Mark m WHERE m.idMark = :idMark")
    , @NamedQuery(name = "Mark.findByMark", query = "SELECT m FROM Mark m WHERE m.mark = :mark")
    , @NamedQuery(name = "Mark.findByDate", query = "SELECT m FROM Mark m WHERE m.date = :date")})
public class Mark implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_mark")
    private Integer idMark;
    @Column(name = "Mark")
    private Integer mark;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "Student", referencedColumnName = "id_stud")
    @ManyToOne
    private Stud student;
    @JoinColumn(name = "Subject", referencedColumnName = "id_subj")
    @ManyToOne
    private Subject subject;

    public Mark() {
    }

    public Mark(Integer idMark) {
        this.idMark = idMark;
    }

    public Integer getIdMark() {
        return idMark;
    }

    public void setIdMark(Integer idMark) {
        this.idMark = idMark;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Stud getStudent() {
        return student;
    }

    public void setStudent(Stud student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMark != null ? idMark.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) object;
        if ((this.idMark == null && other.idMark != null) || (this.idMark != null && !this.idMark.equals(other.idMark))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mark[ idMark=" + idMark + " ]";
    }
    
}
