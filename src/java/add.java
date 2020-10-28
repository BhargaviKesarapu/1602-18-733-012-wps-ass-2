/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRASAD
 */
public class add extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            
            String name=request.getParameter("name");
            String pass=request.getParameter("pass");
            String email=request.getParameter("email");
            String mobile=request.getParameter("mobile");
            String dob=request.getParameter("dob");
            String exp=request.getParameter("explorer");
            String chrome=request.getParameter("chrome");
            String fire=request.getParameter("firefox");
            String animal=request.getParameter("animal");
            String cool=request.getParameter("cool");
            String like=request.getParameter("like");
            String color=request.getParameter("color");
            String sport=request.getParameter("sport");
            String about=request.getParameter("about");
            
            String url="jdbc:mysql://localhost:3306/test";
            String uname="root";
            String passw="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,uname,passw);
            Statement st=con.createStatement();
            String sql = "INSERT INTO datatable (name, password, email, mobile, dob, Use_Exp, Use_chrome, Use_Fire, animal, liked, cool, sports, about, color)" +
                    "VALUES ('"+name+"','"+pass+"','"+email+"','"+mobile+"','"+dob+"','"+exp+"','"+chrome+"','"+fire+"','"+animal+"','"+like+"','"+cool+"','"+sport+"','"+about+"','"+color+"')";
            st.execute(sql);
            
//            out.println(name +pass +dob+email+exp+fire+animal+cool+like+color+sport+about);
            out.println("Your details successfully submitted to database");
            out.println("<a href='index.html'>goback</a>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
