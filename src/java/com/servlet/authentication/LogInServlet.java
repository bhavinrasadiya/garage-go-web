package com.servlet.authentication;

import com.servlet.dao.DaoClass;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "LogInServlet", urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = DaoClass.getConnection();
        String email = request.getParameter("tfEmail");
        String password = request.getParameter("tfPassword");
        String userType = request.getParameter("userType");
        //System.out.println("User Type: " + userType);
        //System.out.println("Email: " + email);
        //System.out.println("Password: " + password);
        PrintWriter out = response.getWriter();
        boolean authentication = DaoClass.authenticateUser(email, password, userType);
        if (authentication) {
            out.print("Welcome, Admin!");
        } else {
            out.print("Wrong Credentials!");
        }
    }

}

