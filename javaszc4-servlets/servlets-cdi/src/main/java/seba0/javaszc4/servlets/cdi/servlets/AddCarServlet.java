package seba0.javaszc4.servlets.cdi.servlets;

import seba0.javaszc4.servlets.cdi.model.entities.Car;
import seba0.javaszc4.servlets.cdi.model.qualifier.Local;
import seba0.javaszc4.servlets.cdi.model.repository.CarRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddCarServlet extends HttpServlet {

    @Inject
    @Local
    private CarRepository carRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String model = req.getParameter("model");
        Car car = new Car();
        car.setName(name);
        car.setModel(model);
        if (!carRepository.create(car)) {
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
            resp.getWriter().println("ERROR");
        } else {
            resp.getWriter().println("OK");
        }
    }
}
