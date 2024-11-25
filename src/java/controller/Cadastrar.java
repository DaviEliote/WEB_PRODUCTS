import model.Produto;
import java.io.IOException;
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



@WebServlet("/ProdutoServlet")
public class Cadastrar extends HttpServlet {
     ProdutoDAO dao = new ProdutoDAO();
     

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
            Date utilDate = sdf.parse(validadeString);
            
    // Converte de java.util.Date para java.sql.Date
                validade = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
}
        String cor = request.getParameter("cor");
        String fornecedor = request.getParameter("fornecedor");
        
   
        
        Produto produto = new Produto(descricao, preco, quantidade, categoria, marca, peso, validade, cor, fornecedor);
        try {
            dao.inserir(produto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp"); dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

