
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class ServletAuthorization extends HttpServlet{
    
    private String loginCorrect = "admine";
    private String passwordCorrect = "123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        
        if (loginCorrect.equals(login) && passwordCorrect.equals(password)) {
//            nextPage = "WEB-INF/vip.html";
            req.getSession().setAttribute("access", true);
        } else {
//            nextPage = "novip.html";
            req.getSession().setAttribute("access", false);
        }
        resp.sendRedirect("/vip");
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String nextPage;
//        if ((boolean)req.getSession().getAttribute("access")) {
//            nextPage = "WEB-INF/vip.html";
//        } else {
//            nextPage = "novip.html";
//        }
//        req.getRequestDispatcher(nextPage).forward(req, resp);
//    }
}
