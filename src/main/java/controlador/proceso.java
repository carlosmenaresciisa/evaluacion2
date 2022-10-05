/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.UsuarioDAO;
import entities.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MenaresDesarrollo
 */
@WebServlet(name = "proceso", urlPatterns = {"/proceso"})
public class proceso extends HttpServlet {

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
        
        //1. recuperamos parametros
        String strId = request.getParameter("txtId");
        String strNombre = request.getParameter("txtNombre").toUpperCase();
        String strApellido = request.getParameter("txtApellido").toUpperCase();    
        String strRut = request.getParameter("txtRut");
        String strEmail = request.getParameter("txtEmail").toUpperCase();
        
        //
        Usuario user = new Usuario();
        
        user.setId(Integer.parseInt(strId));
        user.setNombre(strNombre);
        user.setApellido(strApellido);
        user.setRut(Integer.parseInt(strRut));
        user.setEmail(strEmail);
        
        UsuarioDAO dao = new UsuarioDAO();
        
        try {
            
            dao.create(user);
            
            
            System.out.println("#### YA CREAMOS BIEN EL REGISTRO:" );
            System.out.println("Nombre:" + user.getNombre());
            System.out.println("Apellido:" + user.getApellido());
            System.out.println("email:" + user.getEmail());
            System.out.println("Rut:" + user.getRut());
            
            
        } catch (Exception ex) {
            System.out.println("#### mensaje de error:" + ex.getMessage());
            
            Logger.getLogger(proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        request.getRequestDispatcher("final.jsp").forward(request, response);
        
        
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
