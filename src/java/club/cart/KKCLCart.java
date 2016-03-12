/*
    Document   : KKCLCart.java
    Created on : Mar 20, 2015, 1:35:30 PM
    Author     : clefebvre1-cc

    Revision History:
        Cody Lefebvre:03.19.2015:created
        Cody Lefebvre:03.20.2015:saved data related to cart and session
        Cody Lefebvre:03.21.2015:check conditions to save on reserve action
 */
package club.cart;

import club.business.Book;
import club.business.ECart;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cody-Ray
 */
@WebServlet(name = "KKCLCart", urlPatterns = {"/KKCLCart"})
public class KKCLCart extends HttpServlet {

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
        //vars for ecart,servlet context,loan items and properties
       ServletContext sc = request.getServletContext();
      ArrayList<Book> loanItem = (ArrayList<Book>) sc.getAttribute("loanItem");
       String action = request.getParameter("action");
       String code = request.getParameter("code"); 
       HttpSession session = request.getSession();
       ECart cart = new ECart();
        //checks if its an empty cart
        if(cart.getCount() == 0)
        {
            if(sc.getAttribute("cart") != null)
            {
                cart = (ECart) session.getAttribute("cart");
            }
        }
        //checks if servletcontext has a value for cart
        if(sc.getAttribute("cart") == null)
        {
            cart = (ECart) session.getAttribute("cart");
        }
        //if cart is now null set blank cart
        if(cart == null)
        {
            cart = new ECart();
        }
        //find reserved item and save in session
        if("reserve".equals(action))
        {
           Book foundBook = ELoan.findItem(loanItem, code);          
           cart.addItem(foundBook);
           ELoan.subtractFromQOH(loanItem, code, 1);
           
           session.setAttribute("cart",cart);
        }
        //forward to jsp via requestDispatcher
        RequestDispatcher dispatcher = request.getSession()
                .getServletContext().getRequestDispatcher("/KKCLCart.jsp");
        dispatcher.forward(request, response);
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
