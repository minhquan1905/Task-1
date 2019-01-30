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
@WebServlet(urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Gets contents of the body of request from ajax in welcome page.
        String payload = request.getReader().lines().collect(Collectors.joining());

        JSONObject obj;

        try {
            // Converts json string to json object.
            obj = new JSONObject(payload);
            String action = obj.getString("action");

            if (action.equals("logout")) {
                // Gets session and don't create new session.
                HttpSession session = request.getSession(false);
                session.invalidate(); // Invalidates this session then unbinds any objects bound to it.

                // Gets cookies and remove cookies about username, password.
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }

                    if (cookie.getName().equals("password")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }

                out.write("success");
            }
        } catch (JSONException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
