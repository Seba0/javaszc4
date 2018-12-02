package seba0.javaszc4.servlets.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = "simple")
public class SimpleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before");
        servletRequest.setAttribute("simpleServletAttribute", "simpleServlet");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after");
    }
}
