
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
                       <a href="./LogoutController">Logout</a>
                    </div>
                    <div class="headerWidget">
                         <a href="./homepage.jsp">Homepage</a>
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
                        //create BookBean object that has all books and book informations
                        ArrayList<BookBean> books = (ArrayList)session.getAttribute("book_edit");
                        out.print("<table border='1', align='center'>");
                        //table headers
                        out.println("<tr>");
                        out.print("<th> Title dsfsdfs </th>");
                        out.print("<th> Author</th>");
                        out.print("<th> Price</th>");
                        out.print("<th> Storage Count</th>"); 
                        //for loop when connected to iterate through the object books
                //      for(int i = 0; i <books.size();i++){                             
                        out.println("</tr>");
                        //example data
                        out.print("<td>Title_example1</td>");
                        out.print("<td>Author_example1</td>");
                        out.print("<td>Price_example1</td>");
                        //code that replaces 3 above lines when connected
                //      out.print("<td>" + books.get(i).getTitle() + "</td>");
                //      out.print("<td>" + books.get(i).getAuthor() + "</td>");  
                //      out.print("<td>" + books.get(i).getPrice() + "</td>");
                
                        //buttons to send to ManageStoreController
                        //Sends quantity with book id to change quantity
                        out.print("<td> <form action='ManageStoreController' method='get'>"
                                + "<input type='text' name='newQuantity' placeholder='books.get(i).getQuantity'>"
                                + "<input type='submit' value='Change Quantity'"
                                + "</form></td>");
                        out.print("<td> <form action='ManageStoreController' method='get'>"
                                + "<input type='hidden' value='books.get(i).getBook_id()'name='book_id'>"
                                + "</form></td>");
                        //sends book_id to ManageStoreController to delete book
                        out.print("<td> <form action='ManageStoreController' method='get'>"
                                + "<input type='hidden' value='booksCart.get(i).getBook_id()'name='book_id'>"
                                + "<input type='submit' value='Remove'"
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
