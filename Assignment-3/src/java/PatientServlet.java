/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 *
 * @author Farrukh
 */
public class PatientServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected String getPatientRecords() {
        Patient patient;
        String htmlTable="";
        String database="";
        try {
            
            DatabaseHelper dbHelper=new DatabaseHelper();
            
            //Sending the relative path from servlet to get a DB connection object. 
            database=getServletContext().getRealPath("./assets/bc170400071.accdb");
            Connection conDb = dbHelper.initDBConn(database);
            String qry = "select * from Patients";
            Statement statement;
            statement = conDb.createStatement();
            ResultSet resultSet = statement.executeQuery(qry);
            while (resultSet.next()) 
            {
              patient=new Patient(resultSet.getString("Patient_Name"), resultSet.getString("CNIC"), resultSet.getString("Gender"), resultSet.getInt("Age"), resultSet.getString("Disease"));
              htmlTable+= "<tr><td>" + patient.getCnic() + "</td>" 
                          + "<td>" + patient.getName() + "</td>"
                          + "<td>" + patient.getGender()+ "</td>"
                          + "<td>" + patient.getAge()+ "</td>"
                          + "<td>" + patient.getDisease()+ "</td>"
                          +"</tr>"
                      ;
            }
            
            conDb.close();
            
        } catch(Exception e) {
            System.out.println(e);
        }
//         catch(SQLException ex) {
//            System.out.println(ex);
//        }
        
        return htmlTable ;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String html="<html>\n" +
           "<head>\n" +
           "<title>Servlet PatientsServlet</title>\n" +
           "</head>\n" +
           "<body>\n" +
           "<div align='center'>\n" +
           "<h1 align='center'>Patients Detail</h1>\n" +
            "<table border='1px' cellpadding='5' bgcolor=lightgrey>\n" +
           "<tr>\n" +
           "<th>\n" +
           "CNIC\n" +
           "</th>\n" +
           "<th>\n" +
           "Name\n" +
           "</th>\n" +
           "<th>\n" +
           "Gender\n" +
           "</th>\n" +
           "<th>\n" +
           "Age\n" +
           "</th>\n" +
           "<th>\n" +
           "Disease\n" +
           "</th>\n" +
           "</tr>\n" +  
               getPatientRecords()
            + "</table>\n" +
           "<br><br> <a href='welcome.html'><button>Go Back</button></a>\n" +
           "</div>\n" +
           "</body>\n" +
           "</html>\n" ;
            
//            out.println(System.getProperty("user.dir"));
//            out.println(new File(".").getCanonicalPath());
//            out.println(getServletContext().getRealPath("./Resources"));
            out.println(html);
            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PatientServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PatientServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");

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
