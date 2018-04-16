<%@page import="java.util.ArrayList"%>
<%@page import="Model.BookBean"%>
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
               
                    
                     <div class="headerWidget">
                         <a href="./SaleController">Sale History</a>
                    </div>
                      <div class="headerWidget">
                         <a href="./LogoutController">Log Out</a>
                    </div>
                    
                        
                        
                        
                        
                        

                </div>

              

                <img src="#" id="logoText" alt="The Bookstore">
            </div>

                <%
                    ArrayList<BookBean> books = (ArrayList)session.getAttribute("books_Manager_info");
                   
                    out.println("<table border='1'>");
                          out.print("<th> Title </th>");
                          out.print("<th> Author </th>");
                          out.print("<th> Price </th>");
                            out.print("<th> Available Quantity </th>");
                           out.print("<th> Description </th>");

                    for (int i = 0 ; i < books.size() ; ++i){
                        out.println("<tr>");
                      

                        out.println("</tr>");
                        
                        out.println("<tr>");
                        out.print("<td> " + books.get(i).getTitle() + "</td>");
                        
                        out.print("<td> " + books.get(i).getAuthor() + "</td>");
                        out.print("<td> " + books.get(i).getPrice()+ "</td>");
                        out.print("<td> " + books.get(i).getQuantity()+ "</td>");
                        out.print("<td> " + books.get(i).getDescription()+ "</td>");

                        out.print("<td>  <form action='ManageStoreController' method='post'> "
                                + "<input type='hidden' value='" +books.get(i).getBook_id() + "' name='book_id' >"
                                        + "<input type='submit' name= 'Modify_Items' value='delete'> <br/>"
                                        + "<input type='text' name='quantity' >  "
                                        + "<input type='submit' name='Modify_Items' value='edit_quantity'> <br/>"
                                       + "<input type='text' name='title' > "
                                        + "<input type='submit' name='Modify_Items' value='edit_title'> <br/> "
                                        + "<input type='text' name='author' > "
                                        + "<input type='submit' name='Modify_Items' value='edit_author'> <br/>"
                                        + "<input type='text' name='price' > "
                                        + "<input type='submit' name='Modify_Items' value='edit_price'> <br/>"
                                        + "<input type='text' name='description' > "
                                        + "<input type='submit' name='Modify_Items' value='edit_description'> <br/> "
                                        + "</form>  </td>");
                        
                        out.println("</tr>");
                    }

                    out.println("</table>");
                    %>
                
                    <h1>Add a Book in your Store</h1>
                    <form action="ManageStoreAddBookController" method="post">
                        <label> Enter book's title </label> 
                        <input type = "text" name="title">
                        <br/>
                        <label> Enter book's author </label> 
                        <input type = "text" name="author">
                        <br/>
                        <label> Enter book's description </label> 
                        <input type = "text" name="description">
                        <br/>
                        <label> Enter book's price </label> 
                        <input type = "text" name="price">
                        <br/>
                        <label> Enter book's quantity </label> 
                        <input type = "text" name="quantity">
                        <br/>
                        <input type="submit" value="Add This Book">                                                                    
                        
                    </form>
            
            


            <div id="footer">
                <hr>
                <p id="footerText">[ footer text ]</p>
            </div>
        </div>
    </body>
</html>
