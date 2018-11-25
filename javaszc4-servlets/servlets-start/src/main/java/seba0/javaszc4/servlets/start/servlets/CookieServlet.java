package seba0.javaszc4.servlets.start.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    private String cookieToString(Cookie cookie) {
        return cookie.getName()
                + "\n\tComment: " + cookie.getComment()
                + "\n\tDomain: " + cookie.getDomain()
                + "\n\tPath: " + cookie.getPath()
                + "\n\tValue: " + cookie.getValue()
                + "\n\tMaxAge: " + cookie.getMaxAge()
                + "\n\tSecure: " + cookie.getSecure()
                + "\n\tVersion: " + cookie.getVersion()
                + "\n";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        Arrays.stream(cookies)
                .map(this::cookieToString)
                .forEach(writer::println);
    }
}
