<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProdutoDAO" %>
<%@ page import="model.Produto" %>

<%
   Produto produto = (Produto) request.getAttribute("produto");
   
   
%>


<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultar por ID</title>
    <link rel="stylesheet" href="css/listar_por_id.css">
</head>
<body>
    <h1>Digite o ID do Produto que Deseja Buscar</h1>

    <form method="get" action="ConsultarPorId">
        <input name="id" type="text" placeholder="Digite o ID" required>
        <button type="submit">Buscar</button>
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th>Quantidade</th>
            <th>Categoria</th>
            <th>Marca</th>
            <th>Peso</th>
            <th>Validade</th>
            <th>Cor</th>
            <th>Fornecedor</th>
        </tr>

        <% if (produto != null) { %>
        <tr>
            <td><%= produto.getId() %></td>
            <td><%= produto.getDescricao() %></td>
            <td><%= produto.getPreco() %></td>
            <td><%= produto.getQuantidade() %></td>
            <td><%= produto.getCategoria() %></td>
            <td><%= produto.getMarca() %></td>
            <td><%= produto.getPeso() %></td>
            <td><%= produto.getValidade() %></td>
            <td><%= produto.getCor() %></td>
            <td><%= produto.getFornecedor() %></td>
            <td>
                <form method="post" action="Delete" class="action-form">
                            <button type="submit" name="id" value="<%= produto.getId() %>">
                                <img src="images/delete.png" width="20" height="20" alt="Deletar">
                            </button>
                        </form>
            </td>
            <td>
                
                
                <a href = "atualizar.jsp"> <img src="images/edit.png" width="20" height="20" alt="Atualizar"></a>
           
            </td>
        </tr>
        <% } else { %>
        <tr>
            <td colspan="10" class="no-data">Produto não encontrado ou não foi consultado.</td>
        </tr>
        <% } %>
    </table>

    <div class="button-container">
        <button><a href="index.html">Início</a></button>
    </div>
</body>
</html>











