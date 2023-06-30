/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.registration;

import com.servlet.dao.DaoClass;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yash
 */
@WebServlet(name = "ConsumerRegistration", urlPatterns = {"/ConsumerRegistration"})
public class ConsumerRegistration extends HttpServlet {

        /**
         * Processes requests for both HTTP <code>GET</code> and
         * <code>POST</code> methods.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet ConsumerRegistration</title>");                        
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet ConsumerRegistration at " + request.getContextPath() + "</h1>");
                        out.println("</body>");
                        out.println("</html>");
                }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                
                String name = request.getParameter("Name");
                String email = request.getParameter("Email");
                long mobile = Long.parseLong(request.getParameter("Mobile-No"));
                String password = request.getParameter("password");
                String gender = request.getParameter("Gender");
                String state = request.getParameter("state");
                String city = request.getParameter("City");
                String address = request.getParameter("address");
                
                try {
                        DaoClass.registerConsumer(name, email, password, mobile, gender, state, city, address);
                        /*
                        System.out.println("Name: " + name);
                        System.out.println(email);
                        System.out.println(mobile);
                        System.out.println(password);
                        System.out.println(gender);
                        System.out.println(address);
                        System.out.println(state);
                        System.out.println(city);
                        */
                        PrintWriter out = response.getWriter();
                        out.print("Registration Successful! You'll now be able to login using Email and Password!");
                } catch (SQLException ex) {
                        Logger.getLogger(ConsumerRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }

}
