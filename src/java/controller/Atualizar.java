package controller;

import model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProdutoDAO;

@WebServlet(name = "Atualizar", urlPatterns = {"/Atualizar"})
public class Atualizar extends HttpServlet {

    ProdutoDAO dao = new ProdutoDAO();
    Produto prod = new Produto();
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        System.out.println("test");
        
        
        try {
            
            Produto produto = dao.consultarPorId(id);
            
            
            request.setAttribute("produto", produto);
             RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar.jsp");
        dispatcher.forward(request, response);
            

        }
        catch (Exception e ) {
            
            e.printStackTrace();
            
            
        }
        
       
        
        
        
     
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String categoria = request.getParameter("categoria");
        String marca = request.getParameter("marca");
        Double peso = Double.parseDouble(request.getParameter("peso"));
        String validadeString = request.getParameter("validade");
        java.sql.Date validade = null;
     
        try {
    // Converte a data de String para java.util.Date
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); // Ajuste o formato de acordo com a data recebida
            Date utilDate = sdf.parse(validadeString);
            
    // Converte de java.util.Date para java.sql.Date
                validade = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
}
        String cor = request.getParameter("cor");
        String fornecedor = request.getParameter("fornecedor");
       
        
   
        
        Produto produto = new Produto(descricao, preco, quantidade, categoria, marca, peso, validade, cor, fornecedor, id);
        try {
            dao.atualizar(produto);
            
        } catch (SQLException ex) {
            Logger.getLogger(Atualizar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Atualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


//        prod.setDescricao(request.getParameter("descricao"));
//        prod.setPreco(Double.parseDouble(request.getParameter("preco")));
//        prod.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
//        prod.setCategoria(request.getParameter("categoria"));
//        prod.setMarca(request.getParameter("marca"));
//        prod.setPeso(Double.parseDouble(request.getParameter("peso")));
//        prod.setValidade();