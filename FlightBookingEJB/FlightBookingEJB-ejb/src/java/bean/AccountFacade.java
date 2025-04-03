/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;


import entities.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dangx
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {

    @PersistenceContext(unitName = "FlightBookingEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    


    // Kiểm tra đăng nhập
    @Override
    public Account login(String username, String password) {
        try {
           
            String queryStr = "SELECT a FROM Account a WHERE a.username = :username AND a.password = :password";
            TypedQuery<Account> query = em.createQuery(queryStr, Account.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            return query.getSingleResult(); // Trả về đối tượng User nếu tìm thấy
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null; // Trả về null nếu không tìm thấy người dùng hoặc có lỗi
        }
    }
    
}
