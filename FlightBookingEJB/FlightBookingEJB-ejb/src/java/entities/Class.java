/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author dangx
 */
@Entity
@Table(name = "Class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Class.findAll", query = "SELECT c FROM Class c"),
    @NamedQuery(name = "Class.findByClassId", query = "SELECT c FROM Class c WHERE c.classId = :classId"),
    @NamedQuery(name = "Class.findByClassName", query = "SELECT c FROM Class c WHERE c.className = :className"),
    @NamedQuery(name = "Class.findByPrice", query = "SELECT c FROM Class c WHERE c.price = :price")})
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Class_Id")
    private String classId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Class_Name")
    private String className;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classID")
    private List<Seat> seatList;

    public Class() {
    }

    public Class(String classId) {
        this.classId = classId;
    }

    public Class(String classId, String className, double price) {
        this.classId = classId;
        this.className = className;
        this.price = price;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlTransient
    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classId != null ? classId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Class)) {
            return false;
        }
        Class other = (Class) object;
        if ((this.classId == null && other.classId != null) || (this.classId != null && !this.classId.equals(other.classId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Class[ classId=" + classId + " ]";
    }
    
}
