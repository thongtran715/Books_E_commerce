/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
/**
 *
 * @author ThongTran
 */
@WebServlet(name = "AdminManageUserController", urlPatterns = {"/AdminManageUserController"})
public class AdminManageUserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
                /*
                    RequestDispatcher rd = null;
                    Uncomment this section when model and views are ready 
                    HttpSession session = request.getSession();
                    UserBean user = (UserBean)session.getAttribute("user_info");
                    if (user != null) {
                    if (user.getUserType().equal("2") == false)
                    {   
                            response.sendRedirect("View/inventory_user.jsp");
                            return;
                    }
                     else{
                        
                            // Fetch all the user 
                            AdminBean admin = new AdminBean();
                            ArrayList<UserBean> users = new ArrayList<UserBean>();
                            users = admin.getAllUser();
                            session.setAttribute("admin_all_users",users);
                            String delete_user = request.getAttribute("delete_user");
                            if (delete_user != null)
                            {
                                    String user_id = request.getParameter("user_id");
                                    // Delete the user (Call it)
                                    // First Check to make sure that user is not admin
                                    if (admin.checkIfUserAdmin(user_id))
                                {
                                        // If they are admin, we can't delete that
                                        String message = "You can't delete other admin";
                                        session.setAttribute("error_message", message); 
                                        rd = request.getRequestDispatcher("View/delete_error.jsp");
                                        rd.forward(request, response);
                                        return;
                                }
                            else {
                                admin.deleteUserById(user_id);
                                
                            }
                            }
                            
                     }
                
                    }
        */
        
        
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
