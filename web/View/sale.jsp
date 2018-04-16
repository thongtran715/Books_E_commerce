<%@page import="Model.UserBean"%>
<%@page import="Model.TransactionBean"%>
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
                         <a href="./ManageStoreController">My Store</a>
                    </div>
                        
                        
                        

                </div>

              

                <img src="#" id="logoText" alt="The Bookstore">
            </div>

                <%
                    ArrayList<TransactionBean> trans = (ArrayList)session.getAttribute("sales_info");
                   
                    out.println("<table border='1'>");
                          out.print("<th> Title </th>");
                          out.print("<th> Author </th>");
                          out.print("<th> Price </th>");
                            out.print("<th> Sold Quantity </th>");
                           out.print("<th> Total </th>");
                           out.print("<th> Buyer name </th>");
                    double total_total = 0.0;
                    for (int i = 0 ; i < trans.size() ; ++i){
                        out.println("<tr>");
                      
                        BookBean book = new BookBean();
                        book = book.getBookById(trans.get(i).getBook_id());

                        out.println("</tr>");
                        
                        out.println("<tr>");
                        out.print("<td> " + book.getTitle() + "</td>");
                        out.print("<td> " + book.getAuthor() + "</td>");
                        out.print("<td> " + book.getPrice()+ "</td>");
                        
                        out.print("<td> " + trans.get(i).getBook_quantity()+ "</td>");
                        double total = trans.get(i).getBook_quantity() * book.getPrice();
                        total_total += total;
                        out.print("<td> " + total+ "</td>");
                        
                        UserBean user = new UserBean();
                        user.fetchUserInfoByID(trans.get(i).getUser_id());
                        out.print("<td> " + user.getName()+ "</td>");
                        
                        
                        out.println("</tr>");
                    }

                    out.println("</table>");
                    out.println("<h1> Your Total Earning is " + total_total + " dollars </h1>");
                    %>
                    
       
            
            
            


            <div id="footer">
                <hr>
                <p id="footerText">[ footer text ]</p>
            </div>
        </div>
    </body>
</html>
