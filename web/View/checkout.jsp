<%--
    Document   : checkout
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>

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
               
                    <a href="./cart.jsp">Cart</a>
                    </div>
                    <div class="headerWidget">
                            <a href="./inventory_user.jsp">Catalog</a>
                    </div>
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

                <h2>checkout</h2>

                <p>[ text ]</p>

                <form action="./confirmation.jsp" method="post">

                    <table id="checkoutTable">
                        <tr>
                            <td>[ form containing fields to
                                <br>capture customer details ]</td>
                        </tr>
                        <tr>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="submit button"></td>
                        </tr>

                    </table>

                </form>

                <div id="infoBox">

                    <div style="border: black solid 1px; height:100px; padding: 10px">
                        [ purchase conditions ]
                    </div>

                    <div id="priceBox">
                        [ purchase calculations:<br>subtotal + delivery charge ]
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
