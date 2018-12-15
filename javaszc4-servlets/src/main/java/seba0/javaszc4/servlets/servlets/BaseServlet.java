package seba0.javaszc4.servlets.servlets;

import com.google.gson.Gson;
import seba0.javaszc4.servlets.model.repository.crud.CRUDRepository;
import seba0.javaszc4.servlets.model.repository.crud.CRUDSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class BaseServlet<T> extends HttpServlet {

    private static final Gson GSON = new Gson();
    private final Class<T> type;

    private BaseServlet() {
        type = null;
    }

    protected BaseServlet(Class<T> type) {
        this.type = type;
    }

    abstract protected CRUDRepository<T> getRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (CRUDSession<T> session = getRepository().openSession()) {
            List<T> users = session.getAll();
            GSON.toJson(users, resp.getWriter());
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        T object = GSON.fromJson(req.getReader(), type);
        try (CRUDSession<T> session = getRepository().openSession()) {
            session.add(object);
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        System.out.println(path);
        if (path != null) {
            try (CRUDSession<T> session = getRepository().openSession()) {
                Arrays.stream(path.split("/"))
                        .filter(this::isLong)
                        .map(Long::parseUnsignedLong)
                        .map(session::getById)
                        .forEach(session::remove);
            }
        }
    }

    private boolean isLong(String i) {
        try {
            Long.parseLong(i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
