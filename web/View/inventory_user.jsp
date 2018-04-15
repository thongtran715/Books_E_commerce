
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
                    <a href="./CartController">Cart</a>
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
                <p id="categoryTitle">[Catalog]</p>
             
                    <%
                        //create BookBean object that holds all the books and information
                        ArrayList<BookBean> books = (ArrayList)session.getAttribute("Books_Info");
                        out.print("<table border='1', align='center'>");

                        //table headers
                        out.println("<tr>");
                        out.print("<th> Title</th>");
                        out.print("<th> Author</th>");
                        out.print("<th> Price</th>");
                        out.print("<th> Quantity</th>");                                    
                        out.println("</tr>");
                        //example data
                        out.println("<tr>");
                        out.print("<td>Title_example1</td>");
                        out.print("<td>Author_example1</td>");
                        out.print("<td>Price_example1</td>");
                        //for loop for when connected to DB
                //      for(int i = 0; i <books.size();i++){

                        //these 3 lines will replace above 3 example lines
                //      out.print("<td>" + books.get(i).getTitle() + "</td>");
                  //    out.print("<td>" + books.get(i).getAuthor() + "</td>");  
                    //  out.print("<td>" + books.get(i).getPrice() + "</td>");
                    
                        //sends quantity information and book_id of which book to add to user cart
                                out.print("<td> <form action='InventoryController' method='get'>"
                                + "<input type='text' name='quantity'>"
                                + "<input type='submit' value='Add to Cart'"
                                + "</form></td>");
                        out.print("<td> <form action='InventoryController' method='get'>"
                                + "<input type='hidden' value='books.get(i).getBook_id()'name='book_id'>"
                                + "</form></td>");
                        out.println("</tr>");
                        
                      //for loop curly bracket
                      //  }
                        out.println("</table>");
                    %>
            </div>        
             <br/> 
        </div>
    </body>
</html>
