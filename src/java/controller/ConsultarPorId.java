/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProdutoDAO;
/**
 *
 * @author davieliote
 */
@WebServlet(name = "ConsultarPorId", urlPatterns = {"/ConsultarPorId"})
public class ConsultarPorId extends HttpServlet {

    Produto produto = new Produto();
    ProdutoDAO dao = new ProdutoDAO();

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        System.out.println("test");
        
        
        try {
            
            Produto produto = dao.consultarPorId(id);
            
            
            request.setAttribute("produto", produto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listar_por_id.jsp"); dispatcher.forward(request, response);

            

        }
        catch (Exception e ) {
            e.printStackTrace();
            
            
        }
        
    }

   
   

    

}
