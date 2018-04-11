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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author ThongTran
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            String checkOut = (String)request.getParameter("checkOut");
            
            if (checkOut != null)
            {
            HttpSession session = request.getSession();
            UserBean user = (UserBean)session.getAttribute("user_info");
            ArrayList<BookCartBean> books = (ArrayList<BookCartBean>)(session.getAttribute("cart_info"));
            
            // Get all the book id and stored in type int
            ArrayList<Integer> books_id = new ArrayList<>();
            
            for ( int i = 0 ; i < books.size(); ++i){
                books_id.add(books.get(i).getBook_id());
            }
            TransactionBean trans = new TransactionBean() ; 
            
            // if they checkout, push every book id in transaction 
            trans.makeTransactionFromBooksId(books_id);
            
            CartBean cart = new CartBean();
            // Remove Attribute
            session.removeAttribute("cart_info");
            cart.clearCartForUserId(user.getUserId());
              rd=request.getRequestDispatcher("View/inventory_user.jsp");  
              rd.include(request, response);
              
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
