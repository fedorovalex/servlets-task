package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import users.UserStorage;

//@WebServlet("/login")
public class AuthorizationServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        UserStorage users = UserStorage.get();
        users.add("admine", "123");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserStorage users = UserStorage.get();

        if (users.validation(login, password)) {
            req.getSession().setAttribute("access", true);
        } else {
            req.getSession().setAttribute("access", false);
        }
        resp.sendRedirect("vip.html");
    }
}
