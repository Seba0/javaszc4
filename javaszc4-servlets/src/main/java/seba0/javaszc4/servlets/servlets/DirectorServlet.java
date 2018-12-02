package seba0.javaszc4.servlets.servlets;

import com.google.gson.Gson;
import seba0.javaszc4.servlets.model.entities.Director;
import seba0.javaszc4.servlets.model.qualifier.Local;
import seba0.javaszc4.servlets.model.repository.DirectorRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "director", urlPatterns = "/director/*")
public class DirectorServlet extends HttpServlet {

    @Local
    @Inject
    private DirectorRepository directorRepository;

    private final Gson gson = new Gson();

    private String getBody(BufferedReader reader) throws IOException {
        return reader.lines()
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String path = req.getPathInfo();
        System.out.println(path);
        System.out.println(req.getReader());
        if (path == null) {
            gson.toJson(directorRepository.getAll(), resp.getWriter());
        } else {
            Set<Director> directors = Arrays.stream(path.split("/"))
                    .map(directorRepository::getByName)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
            gson.toJson(directors, resp.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        System.out.println(req.getPathInfo());
        String json = getBody(req.getReader());
        System.out.println(json);
        Director director = gson.fromJson(json, Director.class);
        resp.setStatus(directorRepository.insert(director)
                ? HttpServletResponse.SC_CREATED
                : HttpServletResponse.SC_EXPECTATION_FAILED);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        System.out.println(path);
        if (path != null) {
            Arrays.stream(path.split("/"))
                    .map(directorRepository::getByName)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .forEach(directorRepository::remove);
        }
    }
}
