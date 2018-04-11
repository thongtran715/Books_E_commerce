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
import javax.servlet.http.HttpSession;


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
            RequestDispatcher rd = null;

            // Check if the email and password is empty 
            if (email.isEmpty () || password.isEmpty()) {
                String message = "Please fill in Email and Password";
                request.setAttribute("error_message", message);
                rd=request.getRequestDispatcher("View/login_error.jsp");  
                 rd.forward(request, response);
                 return;
            }
            
            else {
            UserBean user = new UserBean();
            // Set the user email
            user.setEmail(email);
            // It means we first check if the user successfully logged in the system
            if (user.checkPassword(password)) {
                // Save the session 
                
                user.fetchUserInfo () ;
                
               
                
                HttpSession session = request.getSession();
                session.setAttribute("user_info", user);     
                // Navigate to different view 
                 if ("0".equals(user.getUserType())) // It means the user is logged in is the normal user
                 {
                 rd=request.getRequestDispatcher("InventoryController");  
                 }
                 else if ("1".equals(user.getUserType())){ // It means the user is logged in is the store manager
                   rd=request.getRequestDispatcher("InventoryController");  
                 }
                 else if ("2".equals(user.getUserType())){
                     rd=request.getRequestDispatcher("AdminController");  
                 }
                 rd.forward(request, response);
            }
            else {
                 String message = "Your email and password is not found. Please check again";
                 request.setAttribute("error_message", message);
                 rd=request.getRequestDispatcher("View/login_error.jsp");  
                 rd.forward(request, response);
            }
            
            
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
