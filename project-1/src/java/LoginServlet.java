/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author cpu11398
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Gets session and don't create new session.
        HttpSession session = request.getSession(false);

        // Checks if session exist.
        if (session.getAttribute("username") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            // Checks cookies and username, password have stored in cookies.
            Cookie[] cookies = request.getCookies();
            if (cookies == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                String userName = "", passWord = "";
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("password")) {
                        passWord = cookie.getValue();
                    }
                }
                if (!userName.isEmpty() && !passWord.isEmpty()) {
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Gets contents of the body of request from ajax.
        String payload = request.getReader().lines().collect(Collectors.joining());

        JSONObject obj;

        try {
            // Converts json string to json object.
            obj = new JSONObject(payload);
            String userName = obj.getString("username");
            String passWord = obj.getString("password");

            if (userName.trim().equals("admin") && passWord.equals("admin")) {

                // Gets session or creates new session if not exist.
                HttpSession session = request.getSession();
                session.setAttribute("username", userName);
                session.setMaxInactiveInterval(5 * 60); // Sets time out between client requests before the servlet container will invalidate this session. 

                // Creates new cookie object and adds to response.
                Cookie ckUsername = new Cookie("username", userName);
                Cookie ckPassword = new Cookie("password", passWord);

                response.addCookie(ckUsername);
                response.addCookie(ckPassword);

                out.write("success");

            } else {
                out.write("fail");
            }

        } catch (JSONException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
