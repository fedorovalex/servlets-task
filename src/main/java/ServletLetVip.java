
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vip")
public class ServletLetVip extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nextPage;
        Boolean access = (Boolean)req.getSession().getAttribute("access");
        if (access != null && access) {
            nextPage = "WEB-INF/vip.html";
        } else {
            nextPage = "novip.html";
        }
        req.getRequestDispatcher(nextPage).forward(req, resp);
    }
}
