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
@WebServlet(name = "ManageStoreController", urlPatterns = {"/ManageStoreController"})
public class ManageStoreController extends HttpServlet {

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
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;
            UserBean user = (UserBean)session.getAttribute("user_info");
            
                if (user == null){
                    response.sendRedirect("View/login.jsp");
                    
                }
                else {
                if (user.getUserType() != 1) // It means that they are not a store manager
                {
                    rd=request.getRequestDispatcher("View/inventory_user.jsp");  
                    rd.forward(request, response);
                    return;
                }
                else {
                    // Now they are manager
                    InventoryBean invenBean = new InventoryBean() ; 
                    ArrayList<BookBean> booksManager = new ArrayList<BookBean>(); 
                    int manager_id = user.getUser_id();
                    booksManager = invenBean.findAllBooksByManagerId(manager_id);
                    CartBean cart = new CartBean();

                    session.setAttribute("books_Manager_info", booksManager);
                    
                    // Check if any interaction from the store manager to the page
                    String action_btn = request.getParameter("Modify_Items");
                    if (action_btn == null){
                        rd=request.getRequestDispatcher("View/StoreManager.jsp");  
                        rd.forward(request, response);
                        return;
                    }
                    if (action_btn != null) {
                            int book_id = Integer.parseInt(request.getParameter("book_id"));
                            int seller_id = user.getUser_id();
                            BookBean book = new BookBean() ; 
                        if (action_btn.equals("edit_quantity")){
                          int quantity = Integer.parseInt(request.getParameter("quantity"));
                            book.updateBookQuantityByStoreManager(book_id, seller_id, quantity);
                            response.sendRedirect("ManageStoreController");
                        }
                        else if (action_btn.equals("edit_title")){
                            String title = (String)request.getParameter("title");
                             book.updateBookTitleByStoreManager(book_id, seller_id, title);
                                                         response.sendRedirect("ManageStoreController");

                        }
                        else if (action_btn.equals("edit_description")){
                            String desc = (String)request.getParameter("description");
                            book.updateBookDescByStoreManager(book_id, seller_id, desc);
                            response.sendRedirect("ManageStoreController");

                        }
                        else if (action_btn.equals("edit_price")){
                           double price = (Double.parseDouble(request.getParameter("price")));
                           book.updateBookPriceByStoreManager(book_id, seller_id, price);
                            response.sendRedirect("ManageStoreController");

                        }
                        else if (action_btn.equals("edit_author")){
                            String author = (String)request.getParameter("author");
                            book.updateBookAuthorByStoreManager(book_id, seller_id, author);
                             response.sendRedirect("ManageStoreController");
    
                        }
                        
                        else if (action_btn.equals("delete")){
                            // Delete that inventory
                            // if they delete, we need to get the book id 
                            invenBean.deleteInventoryItemByBookID(book_id);
                            response.sendRedirect("ManageStoreController");
                        }
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
