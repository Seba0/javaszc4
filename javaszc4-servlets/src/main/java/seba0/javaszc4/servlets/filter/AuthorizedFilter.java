package seba0.javaszc4.servlets.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = "hello")
public class AuthorizedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String login = servletRequest.getParameter("login");
        String pass = servletRequest.getParameter("password");
        if (login != null && pass != null &&
                login.length() > 7 && pass.contains("!")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter()
                    .println("No access to resource");
        }
    }
}
