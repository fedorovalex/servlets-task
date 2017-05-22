
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class ServletAuthorization extends HttpServlet {

    private static final String LOGIN_CORRECT = "admine";
    private static final String PASSWORD_CORRECT = "123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (LOGIN_CORRECT.equals(login) && PASSWORD_CORRECT.equals(password)) {
            req.getSession().setAttribute("access", true);
        } else {
            req.getSession().setAttribute("access", false);
        }
        resp.sendRedirect("vip.html");
    }
}
