/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bean;

import entities.Flight;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dangx
 */
@Local
public interface FlightFacadeLocal {

    void create(Flight flight);

    void edit(Flight flight);

    void remove(Flight flight);

    Flight find(Object id);

    List<Flight> findAll();

    List<Flight> findRange(int[] range);

    int count();
    
}
