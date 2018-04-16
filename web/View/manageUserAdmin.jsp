<%@page import="Model.UserBean"%>
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
                         <a href="./AdminManageInventorysController">Manage Controller</a>
                    </div>


                <%
                    ArrayList<UserBean> users = (ArrayList)session.getAttribute("admin_all_users");
                   
                    out.println("<table border='1'>");
                          out.print("<th> Email </th>");
                          out.print("<th> Name </th>");
                          out.print("<th> ID </th>");
                        out.print("<th> Type of User </th>");
                                           
                    for (int i = 0 ; i < users.size() ; ++i){
                        out.println("<tr>");
                      

                        out.println("</tr>");
                        
                        out.println("<tr>");
                        out.print("<td> " + users.get(i).getEmail() + "</td>");
                        
                        out.print("<td> " + users.get(i).getName()+ "</td>");
                        out.print("<td> " + users.get(i).getUser_id()+ "</td>");
                        if (users.get(i).getUserType() == 1){
                            out.print("<td> Store Manager</td>");
                        }
                        if (users.get(i).getUserType() == 0){
                            out.print("<td> Normal User</td>");
                        }
                        
                        
                        out.print("<td>  <form action='AdminManageUserController' method='post'> "
                                + "<input type='hidden' value='" +users.get(i).getUser_id() + "' name='user_id' >"
                                + "<input type='submit' name= 'modify' value='delete_user'>   "
                                        + "<input type='submit' name= 'modify' value='change_admin'>"
                                        + "<input type='submit' name= 'modify' value='change_store_manager'>"
                                        +"<input type='submit' name= 'modify' value='change_user'>"
                                        + "</form>  </td>");
                        
                        out.println("</tr>");
                    }

                    out.println("</table>");
                    %>
                
       
            
            
            


            <div id="footer">
                <hr>
                <p id="footerText">[ footer text ]</p>
            </div>
        </div>
    </body>
</html>
