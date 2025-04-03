package controller;

import bean.AccountFacadeLocal;
import entities.Account;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import entities.User;
import bean.UserFacadeLocal;



@WebServlet("/login")
public class LoginController extends HttpServlet {

    // Inject AccountFacade EJB
    @EJB
    private AccountFacadeLocal accountFacade;
    @EJB
    private UserFacadeLocal userFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       
        System.out.println(username);
        System.out.println(password);

        // Kiểm tra đăng nhập với AccountFacade
        Account account = accountFacade.login(username.replace(" ",""), password.replace(" ",""));
        //System.out.println(account);
        if (account != null) {
            // Nếu tìm thấy người dùng hợp lệ
            User user = account.getUserId();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("booking.jsp"); // Chuyển hướng tới trang welcome.jsp
        } else {
            // Nếu không tìm thấy người dùng hợp lệ
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("login.jsp").forward(request, response); // Quay lại trang login.jsp
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}