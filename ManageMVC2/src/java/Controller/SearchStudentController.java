/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ManageDAO;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchStudentController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String inputSearch = request.getParameter("inputSearch");
            String searchOption = request.getParameter("searchOption");
            
            
            ManageDAO manageDAO = new ManageDAO();
            switch (searchOption) {
                case "1":
                    List<Student> listStudent = manageDAO.searchByName(inputSearch);
                    request.setAttribute("list", listStudent);
                    break;

                case "2":
                    List<Student> listSearchByBod = manageDAO.searchByBod(inputSearch);
                    request.setAttribute("list", listSearchByBod);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchStudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            request.getRequestDispatcher("ManageStudent.jsp").forward(request, response);
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
    }

}
