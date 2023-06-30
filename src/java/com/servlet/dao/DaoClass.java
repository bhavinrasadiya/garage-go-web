/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.dao;

import java.sql.*;

/**
 *
 * @author hp
 */
public class DaoClass {
    
    public static Connection getConnection() {
        Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/garagego", "root", ""); 
                
            } catch (Exception e) {
                System.out.println("Exception Occured: " + e);
            }
        return con;   
    }
    
    public static boolean authenticateUser(String emailID, String password, String userType) {
        
        try {
            Connection con = getConnection();
            PreparedStatement pst;
            ResultSet rs;
            switch(userType) {
                case "administrator":
                    System.out.println("Amdin Block Called From DAO class!");
                    pst = con.prepareStatement("select * from administrator where email = ? and password = ?");
                    pst.setString(1, emailID);
                    pst.setString(2, password);
                    rs = pst.executeQuery();
                    System.out.println("Query Executed!");
                    if(rs.next())
                        return true;
                    break;
                case "mechanic":
                    pst = con.prepareStatement("select * from mechanic where email = ? and password = ?");
                    pst.setString(1, emailID);
                    pst.setString(2, password);
                    rs = pst.executeQuery();
                    if(rs.next())
                        return true;
                    break;
                default:
                    pst = con.prepareStatement("select * from consumer where email = ? and password = ?");
                    pst.setString(1, emailID);
                    pst.setString(2, password);
                    rs = pst.executeQuery();
                    if(rs.next())
                        return true;
                    break;
            }
            

        } catch (Exception e) {
        }
        
        return false;
    }
    
    /*
        System.out.println("Name: " + name);
        System.out.println(email);
        System.out.println(mobileNo);
        System.out.println(gender);
        System.out.println(password);
    */
    public static void registerAdmin(String name, String email, long mobileNo, String gender, String password) throws SQLException {
        Connection con = getConnection();
        Statement smt = con.createStatement();
        String sqlQuery = "insert into administrator(Name, Email, mobileno, Gender, Password) values('" +name+ "', '"+ email +"', "+ mobileNo +", '"+ gender +"', '"+ password +"' ) ";
        smt.executeUpdate(sqlQuery);
        System.out.println("Done!");
        
    }
    
    public static void registerConsumer(String name, String email, String password, long mobileNo, String gender, String state, String city, String address) throws SQLException {
            Connection con = getConnection();
            Statement smt = con.createStatement();
            //INSERT INTO `consumer`(`C_ID`, `Name`, `Email`, `Password`, `MobileNo`, `Gender`, `State`, `City`, `Address`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9])
            String sqlQuery = "insert into consumer(Name, Email, Password, MobileNo, Gender, State, City, Address) values('" +name+ "', '" +email+ "', '" +password+ "', " +mobileNo+ ", '" +gender+ "', '" +state+ "', '" +city+ "', '" +address+ "' )";
            smt.executeUpdate(sqlQuery);
            System.out.println("Done!");
    }
    
    public static void registerMechanic() throws SQLException {
            Connection con = getConnection();
            Statement smt = con.createStatement();
            //INSERT INTO `mechanic`(`M_ID`, `Name`, `Email`, `Password`, `MobileNo`, `State`, `City`, `WorkType`, `Gender`, `Status`, `Rating`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9],[value-10],[value-11])
            //String sqlQuery = "insert into mechanicp(Name, Email, Password, MobileNo, State, City, WorkType, Gender) values('" +name+ "', '" +email+ "', '" +password+ "', '" +mobileNo+ "', '" +state+ "', '" +city+ "', '" +workType+ "', '" +gender+ "', )";
            //smt.executeUpdate(sqlQuery);
            System.out.println("Done!");
    }
}
