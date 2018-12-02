package seba0.javaszc4.servlets.servlets;

import seba0.javaszc4.servlets.model.repository.ColorRepository;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/color")
public class ColorServlet extends HttpServlet {

    @Inject
    private ColorRepository colorRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        showPage(
                resp.getWriter(),
                colorRepository.getBackground());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bg = req.getParameter("color");
        colorRepository.setBackground(bg);
        showPage(resp.getWriter(), bg);

    }

    private void showPage(PrintWriter writer, String color) {
        writer.println("<html><body style='background-color: " + color + ";'>" +
                "<form method='post'>" +
                "<input type='color' name='color' value='" + color + "'/>" +
                "<input type='submit'/>" +
                "</form>" +
                "</body></html>"
        );
    }
}
