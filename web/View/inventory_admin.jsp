
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
                       <a href="./LogoutController">Logout</a>
                    </div>
                    <div class="headerWidget">
                         <a href="./homepage.jsp">Hompage</a>
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
                        // creating BookBean object that holds all the users?
                        // Should probably be a different bean just following controller
                        ArrayList<BookBean> admin_all_users = (ArrayList)session.getAttribute("admin_all_books");
                        
                        // need to print out subtotal from bookcartbean method
                        out.print("<p id='categoryTitle'>[ All Users ]</p>");
                        
                        
                        
                        out.print("<table border='1', align='center'>");
                        // cant use for loop until linked database
                        // use object that contains all users 
               //    for(int i = 0; i <admin_all_users.size();i++){
                        out.println("<tr>");
                        //titles for table
                        out.print("<th> Email </th>");
                                        out.print("<th> Password</th>");
                                                        out.print("<th> Rank</th>");
                                                                   
                                                        
                        out.println("</tr>");
                        out.print("<td>Email_1</td>");
                        out.print("<td>Password_1</td>");
                        out.print("<td>Rank_1</td>");
              

                        //need to print out all the users from from admin_all_users object
                        //these lines should replace the above 3 when connected
                //        out.print("<td>" + admin_all_users.get(i).getEmail() + "</td>");
                //        out.print("<td>" + admin_all_users.get(i).getPassword() + "</td>");  
                //        out.print("<td>" + admin_all_users.get(i).getRank() + "</td>");
                        
                        //sends action to AdminManageInventoryController , gives the userId that needs to 
                        // be deleted
                        out.print("<td> <form action='AdminManageInventorysController' method='get'>"
                                + "<input type='hidden' value='admin_all_users.get(i).getUserId()'name='user_id'>"
                                + "<input type='submit' value='Delete'"
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
