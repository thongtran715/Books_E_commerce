<%@page import="Model.CartBean"%>
<%@page import="Model.UserBean"%>
<%@page import="Model.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bookstore.css">
        <title>The Bookstore</title>
    </head>
    <body>
        <div id="main">
            <div id="header">
                <div id="widgetBar">
                    <div class="headerWidget">
                    <a href="./InventoryController">Catalog</a>
                    </div>
                    <div class="headerWidget">
                            <a href="./LogoutController">Log Out</a>
                    </div>
                    <div class="headerWidget">
                       <a href="./CartController">Cart</a>
                    </div>
                </div>
                <a href="./InventoryController">
                    <img src="./Images/download.jpg" id="logo" alt="Bookstore">
                </a>
                <img src="./Images/logo.png" id="logoText" alt="The Bookstore">
            </div>
            <div id="centerColumn">
                <h2>Checkout</h2>
                <p>[ Information about your Checkout ]</p>
                    <%
                 //need to print out books in cart from
                 //cart_info object giving from controller
                 out.print("<table id='checkoutTable'>");
                 //create BookCartBean object that holds information about the users cart   
                 //should have all books
                 ArrayList<BookBean> cart = (ArrayList)session.getAttribute("cart_info");
                 //start of an example
                 //table headers
                 out.println("<tr>");
                 out.print("<th>Title</th>");
                 out.print("<th>Price</th>");
                 out.print("<th>Quantity</th>");
                 out.println("</tr>");
                 //example1
             
                 
                 //when database is connected can uncomment section and should print out
                 //all the books user has
                     for(int i = 0; i < cart.size(); i++){
                    out.println("<tr>");
                    out.print("<td>" + cart.get(i).getTitle()+"</td>");
                    out.print("<td>" + cart.get(i).getPrice()+"</td>");
                    out.print("<td>" + cart.get(i).getQuantity()+"</td>");
                    out.print("</tr>");
                 }
                 
                 //creates confirm button that sends to confirmation page
                      out.print("<td></td><td>"
                              + "<form action='CheckoutController' method='post'>"
                              + "<input type='submit' name='checkOut' value='Checkout Now'> </form>  </td> ");
                              
                   out.print("</table>"); 
                 
                                    %>
                
                <div id="infoBox">
                    <div style="border: black solid 1px; height:100px; padding: 10px">
                        <%
                        //Need to print out user details using user_info sent from controller
                        //create user object that has the current user logged in   
                         UserBean user = (UserBean)session.getAttribute("user_info");
                         //example data
                         out.println("<h4>User details</h4>");
                        // out.println("Example Username");
                         // code that should print out user when connected to DB              
                         out.println(user.getName());
                         out.println("</br>");
                         //code that should print out user email when connected to DB
                             out.println(user.getEmail());
                         //out.println("Example Email");
                        %>
                    </div>


                    <div id="priceBox">
                        <% 
                            
                          //need to print out subtotal from cart_info bean sent from controller
                          out.print("<h4>Subtotal:</h4>");
                          //code taht should print out subtotal
                          CartBean total = new CartBean(); 
                         
                          out.print(total.returnTotal(user.getUser_id()));
                        
                        %>
                    </div>
                </div>
            </div>

            <div id="footer">
                <hr>
                <p id="footerText">[ footer text ]</p>
            </div>
        </div>
    </body>
</html>