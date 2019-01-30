<%-- 
    Document   : welcome
    Created on : Jan 22, 2019, 4:10:33 PM
    Author     : cpu11398
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
            function myFunction() {
               
                $.ajax({
                    url: "LogoutServlet",
                    type: "post",
                    contentType: 'application/json',
                    dataType: 'text',

                    data: JSON.stringify({
                        action: "logout"
                    }),
                    success: function (response) {
                        if (response === "success") {
                            window.location.href = "login.jsp";
                        }
                       
                    }
                });
            }
        </script>
    </head>
    <body>
        <h1>Welcome, <%= session.getAttribute("username") %> !</h1>
        <a href="" onclick="myFunction()">Log out</a>
    </body>
</html>
