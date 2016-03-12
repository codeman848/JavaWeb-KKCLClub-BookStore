/*
    Document   : KKCLCart.java
    Created on : Mar 24, 2015, 1:35:30 PM
    Author     : clefebvre1-cc

    Revision History:
        Cody Lefebvre:03.24.2015:created
        Cody Lefebvre:03.24.2015:saved data related to cart and session
        Cody Lefebvre:03.24.2015:add back to QOH for reserved books cleared
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
@WebServlet(name = "KKCLClearCart", urlPatterns = {"/KKCLClearCart"})
public class KKCLClearCart extends HttpServlet {

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
        //vars for servlet context,session and cart
        ServletContext sc = request.getServletContext();
        ECart cart = new ECart();
        HttpSession ss = request.getSession();
        
        //save cart in session if its not null
        if(cart.getCount() == 0)
        {
            if(ss.getAttribute("cart") != null)
            {
                cart = (ECart) ss.getAttribute("cart");
                ss.setAttribute("cartSession", cart);
                
                ArrayList<Book>list = cart.getItems();
                int x = list.size() - 1;
                
                //add bad to QOH for each book Unreserved
                for(int i = x; i >= 0;i--)
                {
                   ELoan.addToQOH((ArrayList<Book>)sc.getAttribute("loanItem"),
                            cart.getItems().get(i).getCode(),
                            ELoan.getQOH(cart.getItems(), 
                                    cart.getItems().get(i).getCode()));
                    cart.removeItem(cart.getItems().get(i));
                }
            }
        }
        //forward back to cart using request dispatcher
        RequestDispatcher rd = sc.getRequestDispatcher("/KKCLCart.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. 
    //Click on
    //the + sign on the left to edit the code.">
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
