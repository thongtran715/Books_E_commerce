

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
                        <a href="./login.jsp">Login</a>
                    </div>

                </div>

                <a href="./homepage.jsp">
                    <img src="#" id="logo" alt="Bookstore">
                </a>

                <img src="#" id="logoText" alt="The Bookstore">
            </div>

            <div id="centerColumn">
                <br/>
                <br/>
                <br/>
                    <div class="container">
                       <form action ="../RegisterController" method="post">
                        Enter Email<input type="text" name="email"> <br/>
                        Enter Password:  <input type="text" name="password_first"> <br/>
                        Re-enter Password:  <input type="text" name="password_second"> <br/>
                        Enter Your Name<input type="text" name="name"> <br/>
                        <input type="submit" value="Register">
                       </form>
                    </div>
                        
                        <br/>
                        <br/>
                        <br/>
                    
            </div>

            <div id="footer">
                <hr>
                <p id="footerText">[ footer text ]</p>
            </div>
        </div>
    </body>
</html>
