/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bean;

import entities.Plane;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dangx
 */
@Local
public interface PlaneFacadeLocal {

    void create(Plane plane);

    void edit(Plane plane);

    void remove(Plane plane);

    Plane find(Object id);

    List<Plane> findAll();

    List<Plane> findRange(int[] range);

    int count();
    
}
