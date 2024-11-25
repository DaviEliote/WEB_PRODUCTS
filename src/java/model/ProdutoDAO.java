package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static model.Conexao.getConexao;


public class ProdutoDAO {
    


    

                           
    public void inserir(Produto produto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO produtos (descricao, preco, quantidade, categoria, marca, peso, validade, cor, fornecedor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setDouble(3, produto.getQuantidade());
            stmt.setString(4, produto.getCategoria());
            stmt.setString(5, produto.getMarca());
            stmt.setDouble(6, produto.getPeso());
            stmt.setDate(7, produto.getValidade());
            stmt.setString(8, produto.getCor());
            stmt.setString(9, produto.getFornecedor());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Produto produto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE produtos SET descricao = ?, preco = ?, quantidade = ?, categoria = ?, marca = ?, peso = ?, validade = ?, cor = ?, fornecedor = ? WHERE id = ?";
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4,produto.getCategoria());
            stmt.setString(5, produto.getMarca());
            stmt.setDouble(6, produto.getPeso());
            stmt.setDate(7, produto.getValidade());
            stmt.setString(8,produto.getCor());
            stmt.setString(9, produto.getFornecedor());
            stmt.setInt(10, produto.getId());
            
            
            stmt.executeUpdate();
        }
    }

        //int id, String descricao, double preco, int quantidade, String categoria,
        //String marca, float peso, java.sql.Date validade, String cor, String fornecedor
    
    public List<Produto> consultarTodos() throws SQLException, ClassNotFoundException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Connection conn = getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setMarca(rs.getString("marca"));
                produto.setPeso(rs.getDouble("peso"));
                produto.setValidade(rs.getDate("validade"));
                produto.setCor(rs.getString("cor"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produtos.add(produto);
            }
        }
        return produtos;
    }

    public Produto consultarPorId(int id) throws SQLException, ClassNotFoundException {
        Produto produto = null;
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                
                produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setMarca(rs.getString("marca"));
                produto.setPeso(rs.getDouble("peso"));
                produto.setValidade(rs.getDate("validade"));
                produto.setCor(rs.getString("cor"));
                produto.setFornecedor(rs.getString("fornecedor"));
                }
            }
        }
        return produto;
    }

    public void deletar(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
