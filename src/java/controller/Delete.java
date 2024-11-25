/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProdutoDAO;
import model.Produto;


@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

    ProdutoDAO dao = new ProdutoDAO();
    Produto prod = new Produto();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        prod.setId(id);
        
        try {
            dao.deletar(prod.getId());
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            response.sendRedirect("listar.jsp");
        }
        catch (Exception e){
            e.printStackTrace();
            
        }
        
        
    }

   
    

}
