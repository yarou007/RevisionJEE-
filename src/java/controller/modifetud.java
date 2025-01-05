/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Etudiants;

/**
 *
 * @author 21655
 */

@WebServlet(name = "modifetud", urlPatterns = {"/modifetud"}) // url mtaa jsp
public class modifetud extends HttpServlet {

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
         Integer id = Integer.parseInt(request.getParameter("id"));
          
        JPAService jpa = new JPAService();
         Etudiants e = null;
        if (jpa.Connexion("RevisionInesPU")){
           e  = jpa.getEtudiant(id); // e -> etudiant 
           String nom = e.getNom(); // e.getNom --> shyraja3li l esm 
           String prenom = e.getPrenom(); // la9ab
              request.setAttribute("id", id);
              request.setAttribute("nom", nom);
              request.setAttribute("prenom", prenom);
              
        RequestDispatcher rds = request.getRequestDispatcher("modifetud.jsp");
        rds.forward(request, response);  
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
        Integer id = Integer.parseInt(request.getParameter("id"));
       String nom = request.getParameter("nom");
       String prenom = request.getParameter("prenom");
       
       JPAService jpa = new JPAService();
       if (jpa.Connexion("RevisionInesPU")){
           String msg = jpa.modifierEtudiant(id, nom, prenom);
           request.setAttribute("msg", msg);
       }
        RequestDispatcher rds = request.getRequestDispatcher("modifetud.jsp");
        rds.forward(request, response); 
          
       
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
