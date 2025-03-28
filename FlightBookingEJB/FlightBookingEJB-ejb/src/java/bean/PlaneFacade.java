/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Plane;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dangx
 */
@Stateless
public class PlaneFacade extends AbstractFacade<Plane> implements PlaneFacadeLocal {

    @PersistenceContext(unitName = "FlightBookingEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlaneFacade() {
        super(Plane.class);
    }
    
}
