package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.*;
import java.util.ArrayList;
/**
 *
 * @author ThongTran
 */
@WebServlet(urlPatterns = {"/AdminManageInventorysController"})
public class AdminManageInventorysController extends HttpServlet {

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
              RequestDispatcher rd = null;
     
               
                    //Uncomment this section when model and views are ready 
                    HttpSession session = request.getSession();
                    UserBean user = (UserBean)session.getAttribute("user_info");
               // Fetch all the user 
                            AdminBean admin = new AdminBean();
                            ArrayList<BookBean> books = new ArrayList<BookBean>();
                            books = admin.getAllBooks();
                            session.setAttribute("admin_all_books",books);
                            String delete_book = request.getParameter("delete_book");
                            if (user == null){
                                response.sendRedirect("View/login.jsp");
                            }
                            else {
                            if (delete_book == null) {

                               rd = request.getRequestDispatcher("View/inventory_admin.jsp");
                                rd.forward(request, response); 
                                return;
                            }
                            else 
                            {
                                    String book_id = request.getParameter("book_id");
                                    // Delete the user (Call it)
                                    admin.deleteBookByBookId(book_id);
                                    System.out.print(book_id);
                                    response.sendRedirect("AdminManageInventorysController");
                                    return;
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
