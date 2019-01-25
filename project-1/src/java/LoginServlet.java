/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author cpu11398
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//       response.setContentType("text/html");
//        String userName = request.getParameter("username");
//        System.out.println("request11: " + request);
//        String passWord = request.getParameter("password");
        String payload = request.getReader().lines().collect(Collectors.joining());
        System.out.println("payload11: " + payload);
        JSONObject obj;
        try {
            obj = new JSONObject(payload);
            String userName = obj.getString("username");
            String passWord = obj.getString("password");
            if (userName.trim().equals("admin") && passWord.equals("admin")) {
                System.out.println("ok!!!");
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("success");
            }
        } catch (JSONException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//
//
//        if (userName.trim().equals("admin") && passWord.equals("admin")) {
//             response.sendRedirect("welcome.jsp");
//        }
//        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
//        String s = br.readLine();
//        System.out.println("s= "+s);
//         if(s != null){
//            try {
//                Gson gson = new Gson();
//                String str = gson.toJson(s);
//                System.out.println("str:" + str);
//                JSONObject json = new JSONObject(str);
//                System.out.println("json111:" + json);
////                 System.out.println("first:" + sb.toString().trim().charAt(0));
//
//                String userName1 = json.getString("username");
//                String passWord = json.getString("password");
//                if (userName1.trim().equals("admin") && passWord.equals("admin")) {
//                    response.sendRedirect("welcome.jsp");
//                }
//            } catch (JSONException ex) {
//                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }

//        if (br.readLine() != null) {
//            String s = br.readLine();
//            System.out.println("s: " + s);
//            try {
//                JSONObject json = new JSONObject(s);
//                System.out.println("json111: " + json);
//                
//            String userName = json.getString("username");
//            String passWord = json.getString("password");
//             if(userName.trim().equals("admin") && passWord.equals("admin")){
//                response.sendRedirect("welcome.jsp");
//            }
//            } catch (JSONException ex) {
//                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//           
//        }
    }

    public static void main(String[] args) throws JSONException {
        String s = "{\"username\":\"admin\",\"password\":\"q\"}";
        JSONObject obj = new JSONObject(s);
        String userName = obj.getString("username");
        System.out.println(userName);
    }

}
