package com.duong.controller;

import com.duong.model.Classes;
import com.duong.service.Clasees.ClassesService;
import com.duong.service.Clasees.IClassesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ClassesServlet", value = "/classes")
public class ClassesServlet extends HttpServlet {
    IClassesService classesService = new ClassesService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "delete":
                    deleteClasses(request, response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                default:
                    listClasses(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertClasses(request, response);
                    break;
                case "edit":
                    updateClasses(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("classes/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Classes> listClasses = classesService.selectAll();
        request.setAttribute("listClasses", listClasses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("classes/list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Classes classes = new Classes(name, description);
        classesService.insert(classes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("classes/create.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        classesService.delete(id);

        List<Classes> listClasses = classesService.selectAll();
        request.setAttribute("listClasses", listClasses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("classes/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Classes classes = new Classes(id, name, description);
        classesService.update(classes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("classes/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Classes existingClasses = classesService.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("classes/edit.jsp");
        request.setAttribute("classes", existingClasses);
        dispatcher.forward(request, response);
    }
}
