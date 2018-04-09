/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import java.util.ArrayList;
/**
 *
 * @author ThongTran
 */
@WebServlet(name = "InventoryController", urlPatterns = {"/InventoryController"})
public class InventoryController extends HttpServlet {

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
            // Get the user_email 
            // Need to have Inventory Model to fetch all the inventory 
            // Check the user if they are not admin user
            
            // In this case, we need to create an inventoryBean object 
            // From Inventory Bean object, we also need to create an array of Books 
            // use inventoryBean object to call to the db and fetch all the information 
            // We need from the Bookbean and store it
            InventoryBean invenBean = new InventoryBean () ;
            ArrayList<BookBean> books = new ArrayList<BookBean>();
            books = invenBean.fetchAllBooks ();
            
            // Finally we also need to save the attribute
            request.setAttribute("Books_Info", books);
            
            
          
            // When we are done with the data, we need to call the view to display it.
            
            UserBean user = (UserBean)request.getAttribute("user_info");
            
              // Check if the button add to cart is clicked
            String add_to_cart  = request.getParameter("add_to_cart");
            if (add_to_cart != null) {
                // User wants to cart to cart 
                int book_id = Integer.parseInt(request.getParameter("book_id"));
                int userId  = Integer.parseInt(user.getUserId());
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                
                // Check if the quanity of the items are in limit
                int quantity_limit = invenBean.number_of_quantity_with_book_id(book_id);
                
                // If the number of quantity purchases are more than limit 
                if (quantity > quantity_limit) {
                    String message = "You can't purchase the quantity more than our limit";
                    request.setAttribute("error_message", message);
                    response.sendRedirect("View/add_cart_fail.jsp");
                }
                
                // Save all the info inside the cartbean 
                CartBean add_item_cart = new CartBean(quantity, book_id,userId);
                if (add_item_cart.addCartToDb()) {
                    // If the cart is added successfully
                    response.sendRedirect("View/add_cart_sucess.jsp");
                }
                else {
                    String message = "Something wrong with your order";
                    request.setAttribute("error_message", out);
                    response.sendRedirect("View/add_cart_fail.jsp");
                }
                
            } 
            
            
            
            
            
            if (user.getUserType() == "2") {
                response.sendRedirect("View/inventory_admin.jsp");
                return;
            }
            else {
            // Need to have inventory view to display
            RequestDispatcher rd = null;
            rd=request.getRequestDispatcher("View/inventory_user.jsp");  
            rd.forward(request, response);
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
