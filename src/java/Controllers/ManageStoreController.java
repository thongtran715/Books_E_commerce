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
            if (user != null) {
                if (user.getUserType() != "1") // It means that they are not a store manager
                {
                    rd=request.getRequestDispatcher("View/inventory_user.jsp");  
                    rd.forward(request, response);
                    return;
                }
                else {
                    // Now they are manager
                    InventoryBean invenBean = new InventoryBean() ; 
                    ArrayList<BookBean> booksManager = new ArrayList<BookBean>(); 
                    String manager_id = user.getUserId();
                    booksManager = invenBean.findAllBooksByManagerId(manager_id);
                    
                    session.setAttribute("books_Manager_info", booksManager);
                    
                    // Check if any interaction from the store manager to the page
                    String action_btn = request.getParameter("action");
                    
                    if (action_btn != null) {
                        if (action_btn.equals("edit_btn")){
                          
                            // if they want to edit - Navigate to different controller
                            rd = request.getRequestDispatcher("./EditManageStoreManager");
                            rd.forward(request, response);
                        }
                        else if (action_btn.equals("delete_btn")){
                            // Delete that inventory
                            // if they delete, we need to get the book id 
                            String book_id = request.getParameter("book_delete_id");
                            invenBean.deleteInventoryItemByBookID(book_id);
                        }
                    }
                    
                    rd=request.getRequestDispatcher("View/store_manager.jsp");  
                    rd.forward(request, response);
                    return;
                }
            }
            else {
                rd = request.getRequestDispatcher("View/login.jsp");
                rd.forward(request,response);
                return;
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
