package seba0.javaszc4.servlets.start.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("post.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collections.list(req.getParameterNames())
                .stream()
                .map(Object::toString)
                .map(name -> name + ": " + req.getParameter((String) name) + "\n")
                .forEach(resp.getWriter()::println);
        BigDecimal l1 = new BigDecimal(req.getParameter("l1"));
        BigDecimal l2 = new BigDecimal(req.getParameter("l2"));
        BigDecimal out = null;
        switch (req.getParameter("oper")) {
            case "+":
                out = l1.add(l2);
                break;
            case "-":
                out = l1.subtract(l2);
                break;
            case "*":
                out = l1.multiply(l2);
                break;
            case "/":
                out = l1.divide(l2);
                break;
            default:
                resp.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);

        }
        resp.getWriter()
                .println(out);
    }
}
