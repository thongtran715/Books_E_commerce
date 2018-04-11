
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

                <a href="#">
                    <img src="#" id="logo" alt="Bookstore">
                </a>

                <img src="#" id="logoText" alt="The Bookstore">
            </div>



            <div id="singleColumn">
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                <p id="categoryTitle">[ selected category ]</p>

                <table id="productTable">
                    <tr>
                        <td class="lightBlue">
                            <img src="#" alt="product image">
                        </td>
                        <td class="lightBlue">
                            [ product name ]
                            <br>
                            <span class="smallText">[ product description ]</span>
                        </td>
                        <td class="lightBlue">[ price ]</td>
                        <td class="lightBlue">
                            <form action="./InventoryController" method="post">
                                <input type="submit" name="add_to_cart" value="Add To Cart">
                            </form>
                        </td>
                    </tr>

      
                </table>
            </div>

            <div id="footer">
                <hr>
                <p id="footerText">[ footer text ]</p>
            </div>
        </div>
    </body>
</html>
