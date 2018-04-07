package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;  
import Model.*;


/**
 *
 * @author ThongTran
 */
@WebServlet(urlPatterns = {"/LogInController"})
public class LogInController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */     
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            AccessBean log = new AccessBean();
            log.emailUserName(email);
            RequestDispatcher rd = null;
            // It means we first check if the user successfully logged in the system
            if (log.logInToDb(password)) {
                // Save the session 
                request.setAttribute("user_info", log);
                // Navigate to different view 
                 if (log.getUserType() == 0 ) // It means the user is logged in is the normal user
                 {
                 rd=request.getRequestDispatcher("CartController");  
                 }
                 else if (log.getUserType() == 1){ // It means the user is logged in is the store manager
                   rd=request.getRequestDispatcher("CartController");  
                 }
                 else {
                     rd=request.getRequestDispatcher("AdminController");  
                 }
                 rd.forward(request, response);
            }
            else {
                 rd=request.getRequestDispatcher("login_error.jsp");  
                 rd.forward(request, response);
            }
            
            
        }
    }

      
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
