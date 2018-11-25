package seba0.javaszc4.servlets.start.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigDecimal sum = BigDecimal.ZERO;
        for (Object val : req.getParameterMap().keySet()) {
            sum = sum.add(new BigDecimal(String.valueOf(val)));
        }
        resp.getWriter()
                .println(sum);
    }
}
