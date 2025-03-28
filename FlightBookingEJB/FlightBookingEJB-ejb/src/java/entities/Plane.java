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
@Table(name = "Plane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plane.findAll", query = "SELECT p FROM Plane p"),
    @NamedQuery(name = "Plane.findByPlaneId", query = "SELECT p FROM Plane p WHERE p.planeId = :planeId"),
    @NamedQuery(name = "Plane.findByName", query = "SELECT p FROM Plane p WHERE p.name = :name")})
public class Plane implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Plane_Id")
    private String planeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planeID")
    private List<Seat> seatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planeId")
    private List<Flight> flightList;

    public Plane() {
    }

    public Plane(String planeId) {
        this.planeId = planeId;
    }

    public Plane(String planeId, String name) {
        this.planeId = planeId;
        this.name = name;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    @XmlTransient
    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planeId != null ? planeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plane)) {
            return false;
        }
        Plane other = (Plane) object;
        if ((this.planeId == null && other.planeId != null) || (this.planeId != null && !this.planeId.equals(other.planeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Plane[ planeId=" + planeId + " ]";
    }
    
}
