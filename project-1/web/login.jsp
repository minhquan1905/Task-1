<%-- 
    Document   : index
    Created on : Jan 21, 2019, 2:39:26 PM
    Author     : cpu11398
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task 1</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
            function myFunction() {
                var username = $('#username').val();
                var password = $('#password').val();
                console.log('username:', username);
                $.ajax({
                    url: "LoginServlet",
                    type: "post",
                    contentType: 'application/json',
                    dataType: 'text',

                    data: JSON.stringify({
                        username: username,
                        password: password
                    }),
                    success: function (response) {
                        if (response === "success") {
                            window.location.href = "welcome.jsp";
                        } else {
                            alert("Usernam or Password is not correct!");
                        }
                    }
                });
            }
        </script>

    </head>
    <body>
        <h2>Login Form</h2>

        <div class="container">
            <label for="uname"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" id="username" name="uname" required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" id="password" name="psw" required>

            <button onclick="myFunction()">Login</button>
            <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" class="cancelbtn">Cancel</button>
            <span class="psw">Forgot <a href="#">password?</a></span>
        </div>
    </body>
</html>
