
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                
             <table>
                <c:forEach items="$(Books_Info)" var="Book_Info">
                    <tr>
                        <td>"${Book_Info.id}</td>
                        <td><c:out value="${Book_Info.title}"/></td>
                        <td><c:out value="${Book_Info.author}"/></td>
                        <td><c:out value="${Book_Info.description}"/></td>
                        <td><c:out value="${Book_Info.price}"/></td>
                        <td><form action="<c:url value='addToCart'/> method="post">
                                  <input type="hidden"
                                         name="book_id"
                                         value="${Book_Info.id}">
                                  <input type="submit"
                                           name="submit"
                                           value="<fmt: message key='addToCart'/>">
                    </tr>
                </c:forEach>
            </table>
            </div>

            <div id="footer">
                <hr>
                <p id="footerText">[ footer text ]</p>
            </div>
        </div>
    </body>
</html>
