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
public class AppointmentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected String getAppointments() {
        Appointment appointment;
        String htmlTable="";
        String database="";
        int number=0;
        try {
            
            DatabaseHelper dbHelper=new DatabaseHelper();
            
            //Sending the relative path from servlet to get a DB connection object. 
            database=getServletContext().getRealPath("./assets/bc170400071.accdb");
            Connection conDb = dbHelper.initDBConn(database);
            String qry =  "SELECT "
                    + "Patients.Patient_Name, "
                    + "Doctors.Doc_Name, "
                    + "Patients.Disease, " //+ "Doctors.Specialization, "          
                    + "Doctors.Visiting_Day FROM Doctors, Patients "
                    + "WHERE Doctors.Specialization=Patients.Disease;";
            
            Statement statement;
            statement = conDb.createStatement();
            ResultSet resultSet = statement.executeQuery(qry);
            while (resultSet.next()) 
            {
              appointment=new Appointment (resultSet.getString("Patient_Name"),resultSet.getString("Doc_Name"), resultSet.getString("Disease"), resultSet.getString("Visiting_Day"));
              htmlTable+= "<tr><td>" + Integer.toString(number+=1) + "</td>" 
                          + "<td>" + appointment.getPatient_name() + "</td>"
                          + "<td>" + appointment.getDoctor_name() + "</td>"
                          + "<td>" + appointment.getDisease()+ "</td>"
                          + "<td>" + appointment.getScheduledDay()+ "</td>"                          
                          +"</tr>" ;
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
           "No.\n" +
           "</th>\n" +
           "<th>\n" +
           "Patient\n" +
           "</th>\n" +
           "<th>\n" +
           "Doctor\n" +
           "</th>\n" +
           "<th>\n" +
           "Disease\n" +
           "</th>\n" +
           "<th>\n" +
           "Visiting Day\n" +
           "</th>\n" +
           "</tr>\n" +  
               getAppointments()
            + "</table>\n" +
           "<br><br> <a href='welcome.html'><button>Go Back</button></a>\n" +
           "</div>\n" +
           "</body>\n" +
           "</html>\n" ;
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println(html);
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AppointmentServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AppointmentServlet at " + request.getContextPath() + "</h1>");
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
