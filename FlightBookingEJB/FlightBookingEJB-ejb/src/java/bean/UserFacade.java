/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dangx
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "FlightBookingEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
  
    public User findByUsername(String username) {
    try {
        String queryStr = "SELECT a FROM User a WHERE a.Username = :Username";
        TypedQuery<User> query = em.createQuery(queryStr, User.class);
        query.setParameter("username", username);

        return query.getSingleResult(); // Trả về đối tượng Account nếu tìm thấy
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return null; // Trả về null nếu không tìm thấy người dùng hoặc có lỗi
    }
}
}
