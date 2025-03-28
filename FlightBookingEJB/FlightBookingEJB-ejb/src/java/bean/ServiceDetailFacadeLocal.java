/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bean;

import entities.ServiceDetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dangx
 */
@Local
public interface ServiceDetailFacadeLocal {

    void create(ServiceDetail serviceDetail);

    void edit(ServiceDetail serviceDetail);

    void remove(ServiceDetail serviceDetail);

    ServiceDetail find(Object id);

    List<ServiceDetail> findAll();

    List<ServiceDetail> findRange(int[] range);

    int count();
    
}
