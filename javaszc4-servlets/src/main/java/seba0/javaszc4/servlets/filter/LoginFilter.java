package seba0.javaszc4.servlets.filter;

import seba0.javaszc4.servlets.services.UserService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = "/main")
public class LoginFilter implements Filter {

    @Inject
    private UserService userService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String login = servletRequest.getParameter("login");
        String pass = servletRequest.getParameter("password");
        if (login != null && pass != null
                && userService.isUser(login, pass)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter()
                    .println("No access to resource");
        }
    }
}
