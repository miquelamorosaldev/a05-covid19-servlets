/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumne
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Llegir DNI del formulari.
        String dniForm = request.getParameter("dni");
        // DNI no introduït correctament.
        boolean dniOK = validarDNI(dniForm);
        
        request.setAttribute("errorForm","DNI no vàlid.");
        redirectJSP("validateClient.jsp",request, response);
        
        // DNI vàlid, però no registrat a la base de dades.
        if(!dniForm.equals("12345678Z"))
            request.setAttribute("errorForm","El DNI no es troba a la base de dades.");
        
        // DNI vàlid i registrat a la base de dades.
        request.setAttribute("userDNI",dniOK);
        redirectJSP("welcomeClient.jsp",request, response);
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
        processRequest(request,response);
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
    
    private void redirectJSP(String JSPname, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Anem a la welcomeClient.jsp
        RequestDispatcher rd=request.getRequestDispatcher(JSPname);
        rd.forward(request, response);
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

    
    private boolean validarDNI(String itDNI) {
        // https://tazasdejava.blogspot.com/2016/09/codigo-java-que-verifica-un-dni-sea.html
        Pattern pat = Pattern.compile("[0-9]{7,8}[A-Za-z]");
        Matcher mat = pat.matcher(itDNI);
        boolean cumplePatron = mat.matches();
        return cumplePatron;
    }
}
