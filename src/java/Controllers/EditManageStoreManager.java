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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author ThongTran
 */
@WebServlet(name = "EditManageStoreManager", urlPatterns = {"/EditManageStoreManager"})
public class EditManageStoreManager extends HttpServlet {

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
                      RequestDispatcher rd = null;

            String book_id = request.getParameter("book_id");
            
            InventoryBean invenBean = new InventoryBean() ; 
            
            BookBean book = new BookBean() ; 
            book = invenBean.fetchBookByBookId(book_id);
            
            HttpSession session = request.getSession();
            session.setAttribute("book_edit", book);
            
            
            
            String change_book_name = request.getParameter("change_book");
            int change_quantity = Integer.parseInt(request.getParameter("change_quantity"));
            String change_author = request.getParameter("change_author");
            String change_title = request.getParameter("change_title");
            String change_description = request.getParameter("change_description");
            double change_price = Double.parseDouble(request.getParameter("change_price"));
            
            String cancel_btn = request.getParameter("cancel_btn");
            if (cancel_btn == null)
            {
            // Change the items 
            invenBean.editInventoryByBookId(book_id, change_book_name, change_quantity,change_author,change_title,change_description,change_price);
            
            rd = request.getRequestDispatcher("View/edit_item_sucess.jsp");
            rd.forward(request, response);
            }
            else {
            rd = request.getRequestDispatcher("View/store_manager.jsp");
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
