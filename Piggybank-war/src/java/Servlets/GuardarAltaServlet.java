/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Usuario;
import facades.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mike
 */
@WebServlet(name = "GuardarAltaServlet", urlPatterns = {"/GuardarAltaServlet"})
public class GuardarAltaServlet extends HttpServlet {

    @EJB
    private UsuarioFacade userFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //obtenemos los parametros del form
        String name = request.getParameter("name");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String dni = request.getParameter("dni");
        int numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        double efectivo = Double.parseDouble(request.getParameter("efectivo"));
        String contrasenia = request.getParameter("contrasenia");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        int dia = Integer.parseInt(request.getParameter("dia"));
        int mes = Integer.parseInt(request.getParameter("mes"));
        int anyo = Integer.parseInt(request.getParameter("anyo"));
        
        Short typeUser = new Short(request.getParameter("typeUser"));
        //creamos el usuario y lo insertamos en la BD
        if(userFacade.find(dni) != null){
            //ERROR! YA ESTABA EN LA BD
        }else{
            //creamos el user
            Usuario newUser = new Usuario(dni, numCuenta, name);
            
            newUser.setApellido1(apellido1);
            newUser.setApellido2(apellido2);
            newUser.setContraseña(contrasenia);
            newUser.setDireccion(direccion);
            newUser.setEfectivo(efectivo);
            newUser.setEmail(email);
            newUser.setFechaNacimiento(new Date(anyo,mes,dia));
            newUser.setNombre(name);
            newUser.setNumeroCuenta(numCuenta);
            newUser.setTipoUsuario(typeUser);
            
            //finalmente, introducimos el usuario
            //el cual creo el nuevo
            //TODO: OJO! REVISAR ESTO
            HttpSession session = request.getSession();
            Usuario admin = (Usuario)session.getAttribute("usuario");
            newUser.setUsuariodni(admin);
            //lo introducimos en la BD
            userFacade.create(newUser);
            //POR ULTIMO REDIRIGIMOS AL JSP
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/confirmacionAlta.jsp");
            rd.forward(request, response);
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
