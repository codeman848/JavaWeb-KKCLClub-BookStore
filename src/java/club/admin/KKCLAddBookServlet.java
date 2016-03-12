/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kkuzyk-cc
 */
@WebServlet(urlPatterns = {"/KKCLAddBook"})
public class KKCLAddBookServlet extends HttpServlet {

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
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            	String code = request.getParameter("code");
		String description = request.getParameter("description");
                String error = "";
		if (code == null || code.isEmpty()) 
                {
                    error += "Book code is required.</br>";
                }
                if (description.length() < 2)
                {
                    error += "Description must have at least 2 characters.</br>";
                }
                if (quantity <= 0)
                {
                    error += "Quantity must be a positive number.</br>";
                }
                if (!error.equals(""))
                {
                    request.setAttribute("error",error); 
                    HttpSession session = request.getSession();
                    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/KKCLAddBook.jsp");
                    dispatcher.forward(request, response);
                }
                else
                {
                    String path = this.getServletContext().getRealPath("/WEB-INF/books.txt");
                    Book book = new Book(code, description, quantity);
                    BookIO.insert(book, path);
                    ArrayList<Book> books = BookIO.getBooks(path);
                    HttpSession session = request.getSession();
                    request.setAttribute("book",books);    
                    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/KKCLDisplayBooks.jsp");
                    dispatcher.forward(request, response);
                }
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
