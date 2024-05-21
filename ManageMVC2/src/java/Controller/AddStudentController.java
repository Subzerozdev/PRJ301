/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ManageDAO;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TNO
 */
public class AddStudentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String address = request.getParameter("address");
            String teachingQuality = request.getParameter("teachingQualaty");
            int numOfCourse = Integer.parseInt(request.getParameter("numOfCourse"));

            String param = "course";
            ArrayList<String> listCourse = new ArrayList<>();
            for (int i = 1; i < numOfCourse + 1; i++) {
                String getCourse = request.getParameter(param + i);
                if (getCourse != null) {
                    listCourse.add(getCourse);
                }
            }

            String stringCoure = "";

            for (int i = 0; i < listCourse.size(); i++) {
                stringCoure += listCourse.get(i);
                if (i < listCourse.size() - 1) {
                    stringCoure += ", ";
                }

            }

            ManageDAO dao = new ManageDAO();
            dao.addStudent(name, dob, address, teachingQuality, stringCoure);

            List<Student> list = dao.findAllStudent();
            request.setAttribute("list", list);

            request.getRequestDispatcher("ManageStudent.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(AddStudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
