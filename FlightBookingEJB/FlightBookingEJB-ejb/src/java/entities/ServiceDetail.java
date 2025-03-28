/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dangx
 */
@Entity
@Table(name = "Service_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceDetail.findAll", query = "SELECT s FROM ServiceDetail s"),
    @NamedQuery(name = "ServiceDetail.findByServiceDetailId", query = "SELECT s FROM ServiceDetail s WHERE s.serviceDetailId = :serviceDetailId"),
    @NamedQuery(name = "ServiceDetail.findByQuantity", query = "SELECT s FROM ServiceDetail s WHERE s.quantity = :quantity")})
public class ServiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Service_Detail_Id")
    private Integer serviceDetailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "Service_Id", referencedColumnName = "Service_Id")
    @ManyToOne(optional = false)
    private Service serviceId;
    @JoinColumn(name = "Ticket_Id", referencedColumnName = "Ticket_Id")
    @ManyToOne(optional = false)
    private Ticket ticketId;

    public ServiceDetail() {
    }

    public ServiceDetail(Integer serviceDetailId) {
        this.serviceDetailId = serviceDetailId;
    }

    public ServiceDetail(Integer serviceDetailId, int quantity) {
        this.serviceDetailId = serviceDetailId;
        this.quantity = quantity;
    }

    public Integer getServiceDetailId() {
        return serviceDetailId;
    }

    public void setServiceDetailId(Integer serviceDetailId) {
        this.serviceDetailId = serviceDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceDetailId != null ? serviceDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceDetail)) {
            return false;
        }
        ServiceDetail other = (ServiceDetail) object;
        if ((this.serviceDetailId == null && other.serviceDetailId != null) || (this.serviceDetailId != null && !this.serviceDetailId.equals(other.serviceDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceDetail[ serviceDetailId=" + serviceDetailId + " ]";
    }
    
}
