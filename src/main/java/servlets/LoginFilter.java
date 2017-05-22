package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        Boolean access = (Boolean) httpRequest.getSession().getAttribute("access");
        if (access != null && access) {
            chain.doFilter(req, resp);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) resp;
            httpResponse.sendRedirect("registration.html");
        }
    }

    @Override
    public void destroy() {
    }
}
