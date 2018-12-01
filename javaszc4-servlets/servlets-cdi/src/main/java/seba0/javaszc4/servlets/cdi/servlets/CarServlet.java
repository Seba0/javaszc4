package seba0.javaszc4.servlets.cdi.servlets;

import seba0.javaszc4.servlets.cdi.model.qualifier.Local;
import seba0.javaszc4.servlets.cdi.model.repository.CarRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get")
public class CarServlet extends HttpServlet {

    @Inject
    @Local
    private CarRepository carRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        carRepository.read()
                .forEach(writer::println);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String model = req.getParameter("model");
//        Car car = new Car();
//        car.setName(name);
//        car.setModel(model);
//        if (!carRepository.create(car)) {
//            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
//            resp.getWriter().println("ERROR");
//        } else {
//            resp.getWriter().println("OK");
//        }
//    }
}
