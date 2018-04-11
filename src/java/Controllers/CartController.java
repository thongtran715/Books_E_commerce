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
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

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
            HttpSession session = request.getSession();
            UserBean user = (UserBean)session.getAttribute("user_info");
            
            if (user != null) {
            int user_id = user.getUserId();
            
            CartBean cart = new CartBean();
            
            ArrayList<BookBean>  booksCart = new ArrayList<BookBean>();
            booksCart = cart.fetchAllCartBooksByUserId(user_id);
            
            session.setAttribute("cart_info", booksCart);
            
            // Check if the edit button is checked, and checked if the delete button is clicked 
            String modify_btn = request.getParameter("Modify_Items");
            int book_id = Integer.parseInt(request.getParameter("book_id"));

            if (modify_btn != null) {
            if (modify_btn.equals("edit")) {
                // First we need to find if this item is existed inside the user db 
                // Get the number of quantity
                int quantity = Integer.parseInt(request.getParameter("edit_quantity"));
                // Check if the quantity from db is good 
                InventoryBean invenBean = new InventoryBean() ; 
                int quantity_limit = invenBean.number_of_quantity_with_book_id(book_id);
                if (quantity > quantity_limit) {
                    String message = "Your quantity is exceed the limit";
                    session.setAttribute("error_message", message);
                    rd = request.getRequestDispatcher("View/add_cart_fail.jsp");
                    rd.forward(request, response);
                    return;
                }
                // If everything is good then call the cart bean to update the storage
                cart.update_quantity_by (user_id, book_id, quantity);
                return;
            }
                else if (modify_btn.equals("delete")) {
                    cart.delete_cart(user_id, book_id);
                return;
                }
            }
            
            // Once getting the user name . We will call the cart to fetch all the 
            // seperate the type for the user
            // Need to have cart view for normal user
            
            if ("2".equals(user.getUserType()) == false) {
                    rd = request.getRequestDispatcher("View/cart.jsp");
                    rd.forward(request, response);
                    return;
            }
            return;
            }
            else {
                response.sendRedirect("View/register.jsp");
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
