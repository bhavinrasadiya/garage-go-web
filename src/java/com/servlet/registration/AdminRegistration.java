/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.registration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.servlet.dao.DaoClass;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yash
 */
@WebServlet(name = "AdminRegistration", urlPatterns = {"/AdminRegistration"})
public class AdminRegistration extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                String name = request.getParameter("Name");
                String email = request.getParameter("Email");
                long mobileNo = Long.parseLong(request.getParameter("MobileNo"));
                String password = request.getParameter("password");
                String gender = request.getParameter("Gender");
                try {
                        
                        System.out.println("Name: " + name);
                        System.out.println(email);
                        System.out.println(mobileNo);
                        System.out.println(gender);
                        System.out.println(password);
                        
                        DaoClass.registerAdmin(name, email, mobileNo, gender, password);
                        System.out.println("Done From Servlet!");
                        PrintWriter out = response.getWriter();
                        out.println("Registration Successful!");
                        out.println("You'll now be able to login using Email Id And Password!");
                } catch (SQLException ex) {
                        Logger.getLogger(AdminRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }

}
