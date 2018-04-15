<%-- 
    Document   : homepage
    Created on : Apr 7, 2018, 9:58:53 AM
    Author     : OutlawGene
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to the Bookstore</title>
        <link rel="stylesheet" type="text/css" href="css/bookstore.css">
    </head>
    <body>
        <div id="main">
            
            <div id="header">
                <div id="widgetBar">

                    <div class="headerWidget">
                        
                        <%--change this to redirect to controller --%>
                        <a href="./cart.jsp">Cart</a>
                    </div>

                    <div class="headerWidget">
                        <%-- should redirect directly to login.jsp without goin to controller --%>
                        <a href="./login.jsp">Login</a>
                    </div>

                </div>

                <a href="#">
                    <img src="./Images/download.jpg" id="logo" alt="Bookstore">
                </a>

                <img src="./Images/logo.png" id="logoText" alt="Bookstore Text">
            </div>
            
            <div id ="indexLeftColumn">
                <h4>Catalog</h4>
                <a href="InventoryController">
                    <img src="./Images/catalog.png" id="logo" align="right" alt="catalog" style="width:300px; height:300px;" >
                </a>
            </div>
            
                <div id ="indexRightColumn">
                    <h2>Description</h2>
                    This is a book store web application for Web Programming.
                    The project uses MVC framework using MySQL as the database.
                    <br/>
                    
                    Our group consist of:<br/>
                    Models:<br/>
                    Views:<br/>
                    Controllers:<br/>

                </div>
            <div id="footer">
                footer
            </div
        </div>
        
        
    </body>
</html>
