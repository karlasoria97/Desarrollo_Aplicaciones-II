package practica.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import practica.dao.ExcursionDAO;
import practica.dao.ExcursionDAOImp;
import practica.model.Excursion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karla
 */
@WebServlet(name = "ExcursionController", urlPatterns = {"/ExcursionController"})
public class ExcursionController extends HttpServlet {

    private static final String LISTA_EXCURSIONES = "/listarExcursiones.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/excursiones.jsp";
    private ExcursionDAO dao;

    public ExcursionController() {
        dao = new ExcursionDAOImp();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_EXCURSIONES;
            int idExcursion = Integer.parseInt(
                    request.getParameter("idExcursion"));
            dao.borrarExcursion(idExcursion);
            request.setAttribute("excursiones", dao.desplegarExcursion());

        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int idExcursion = Integer.parseInt(
                    request.getParameter("idExcursion"));
            Excursion excursion = dao.elegirExcursion(idExcursion);
            request.setAttribute("excursiones", excursion);

        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;

        } else {
            forward = LISTA_EXCURSIONES;
            request.setAttribute("excursiones", dao.desplegarExcursion());

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Excursion excursion = new Excursion();
        String idExcursion = request.getParameter("idExcursion");
        excursion.setDestino(request.getParameter("destino"));
        excursion.setActividad(request.getParameter("actividad"));
        excursion.setTransporte(request.getParameter("transporte"));
        excursion.setHotel(request.getParameter("hotel"));
        
        if(idExcursion==null || idExcursion.isEmpty()){
            dao.agregarExcursion(excursion);
        }else{
            excursion.setIdExcursion(Integer.parseInt(idExcursion));
            dao.cambiarExcursion(excursion);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_EXCURSIONES);
        request.setAttribute("excursiones", dao.desplegarExcursion());
        view.forward(request, response);
                
    }

}

