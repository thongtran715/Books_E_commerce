
<%@page import="Model.BookCartBean"%>
<%@page import="Model.BookBean"%>
<%@page import="java.util.ArrayList"%>
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
                       <a href="./login.jsp">Login</a>
                    </div>
                    <div class="headerWidget">
                         <a href="./CheckoutController">Checkout</a>
                    </div>
                </div>
                   <!--change this to redirect directly to index.html -->
                <a href="./homepage.jsp">
                    <img src="./Images/download.jpg" id="logo" alt="Bookstore">
                </a>
                <img src="./Images/logo.png" id="logoText" alt="The Bookstore">
            </div>
            <div id ="singleColumn">

                    <%
                        
                        
                        out.print("<div>");
                        //get BookCartBean object that holds cart infor for user from controller
                        ArrayList<BookCartBean> booksCart = (ArrayList)session.getAttribute("cart_info");
                        
                        // need to print out subtotal from bookcartbean method
                        out.print("<p id='categoryTitle'>[ Cart Subtotal: "+ /* booksCart.getSubtotal*/" ]</p>");
                        
                        out.print("<table border='1', align='center'>");
                        
                        //cant use for loop until linked database
                        //for(int i = 0; i <booksCart.size();i++){
                        
                        //table headers
                        out.println("<tr>");
                        out.print("<th> Title </th>");  
                        out.print("<th> Author</th>");
                        out.print("<th> Price</th>");
                        out.print("<th> Quantity</th>");        
                        out.println("</tr>");
                        
                        out.println("<tr>");
                        //these need to be deleted when object is connected
                        out.print("<td>Title_example1</td>");
                        out.print("<td>Author_example1</td>");
                        out.print("<td>Price_example1</td>");
                        out.print("<td>Quantity_example1</td>");

                //need to print out all books in the users cart here usng BookCartBean giving from Controller
                //can uncomment when hooked up to database
                //      out.print("<td>" + booksCart.get(i).getTitle() + "</td>");
                //      out.print("<td>" + booksCart.get(i).getAuthor() + "</td>");  
                //      out.print("<td>" + booksCart.get(i).getPrice() + "</td>");
                //      out.print("<td>" + booksCart.get(i).getQuantity() + "</td>");
                       
                        //this needs to be kept
                        //creates remove button that sends book_id to controller for deletion from cart
                        // sends the action to InventoryController
                        out.print("<td> <form action='InventoryController' method='get'>"
                                + "<input type='hidden' value='booksCart.get(i).getBook_id()'name='book_id'>"
                                + "<input type='submit' value='Remove'"
                                + "</form></td>");
                        out.println("</tr>");

                       //for loop curly bracket
                       //  }
                      
                        out.println("</table>");
                        out.print("</div>");
                    %>
                    
                    
            </div>        
             <br/>  
        </div>
    </body>
</html>
