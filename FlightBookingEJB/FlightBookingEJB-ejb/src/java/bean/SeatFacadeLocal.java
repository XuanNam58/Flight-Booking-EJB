/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bean;

import entities.Seat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dangx
 */
@Local
public interface SeatFacadeLocal {

    void create(Seat seat);

    void edit(Seat seat);

    void remove(Seat seat);

    Seat find(Object id);

    List<Seat> findAll();

    List<Seat> findRange(int[] range);

    int count();
    
}
