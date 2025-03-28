/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dangx
 */
@Entity
@Table(name = "Seat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s"),
    @NamedQuery(name = "Seat.findBySeatID", query = "SELECT s FROM Seat s WHERE s.seatID = :seatID"),
    @NamedQuery(name = "Seat.findBySeatNum", query = "SELECT s FROM Seat s WHERE s.seatNum = :seatNum")})
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Seat_ID")
    private String seatID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Seat_Num")
    private short seatNum;
    @JoinColumn(name = "Class_ID", referencedColumnName = "Class_Id")
    @ManyToOne(optional = false)
    private Class classID;
    @JoinColumn(name = "Plane_ID", referencedColumnName = "Plane_Id")
    @ManyToOne(optional = false)
    private Plane planeID;

    public Seat() {
    }

    public Seat(String seatID) {
        this.seatID = seatID;
    }

    public Seat(String seatID, short seatNum) {
        this.seatID = seatID;
        this.seatNum = seatNum;
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public short getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(short seatNum) {
        this.seatNum = seatNum;
    }

    public Class getClassID() {
        return classID;
    }

    public void setClassID(Class classID) {
        this.classID = classID;
    }

    public Plane getPlaneID() {
        return planeID;
    }

    public void setPlaneID(Plane planeID) {
        this.planeID = planeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seatID != null ? seatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) object;
        if ((this.seatID == null && other.seatID != null) || (this.seatID != null && !this.seatID.equals(other.seatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Seat[ seatID=" + seatID + " ]";
    }
    
}
