package seba0.javaszc4.servlets.start.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Objects;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Welcome");
        writer.println("");
        HttpSession session = req.getSession(false);
        if (!Objects.isNull(session))
            Collections.list(session.getAttributeNames())
                    .stream()
                    .map(Object::toString)
                    .forEach(name -> writer.println(name + ": " + session.getAttribute((String) name)));
    }
}
