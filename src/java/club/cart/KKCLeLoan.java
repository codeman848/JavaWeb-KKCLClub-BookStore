/*
    Document   : KKCLELoan.java
    Created on : Mar 22, 2015, 1:35:30 PM
    Author     : clefebvre1-cc

    Revision History:
        Cody Lefebvre:03.22.2015:created
        Cody Lefebvre:03.23.2015:saved data related to loanItems and save 
                                 in servlet context
 */

package club.cart;

import club.business.Book;
import club.business.ELoan;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clefebvre1-cc
 */
@WebServlet(name = "KKCLeLoan", urlPatterns = {"/KKCLELoan"})
public class KKCLeLoan extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //vars for string path to books and servlet context
        ServletContext context = request.getServletContext();
        String path = context.getRealPath("/WEB-INF/books.txt");
        
        ArrayList<Book> loanItem = new ArrayList();
        
        //if loanitem in context is null set loan item to null
        if(context.getAttribute("loanItem") == null)
        {
            loanItem = (ArrayList<Book>) context.getAttribute("loanItem");
        }
        //if loan item is null load it with loan items and save in context
        if(loanItem == null)
        {
            loanItem = ELoan.loadItems(path);
            context.setAttribute("loanItem", loanItem);
        }
        //forward via request dispatcher
        RequestDispatcher rd = context.getRequestDispatcher("/KKCLELoan.jsp");
        rd.forward(request, response);
         
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. 
    //Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse 
            response)
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
    protected void doPost(HttpServletRequest request, HttpServletResponse 
            response)
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
