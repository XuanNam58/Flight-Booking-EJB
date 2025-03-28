/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bean;

import entities.Class;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dangx
 */
@Local
public interface ClassFacadeLocal {

    void create(Class class1);

    void edit(Class class1);

    void remove(Class class1);

    Class find(Object id);

    List<Class> findAll();

    List<Class> findRange(int[] range);

    int count();
    
}
