<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProdutoDAO" %>
<%@ page import="controller.Produto" %>

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
            <th>Descri��o</th>
            <th>Pre�o</th>
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
        </tr>
        <% } else { %>
        <tr>
            <td colspan="10" class="no-data">Produto n�o encontrado ou n�o foi consultado.</td>
        </tr>
        <% } %>
    </table>

    <div class="button-container">
        <button><a href="index.html">In�cio</a></button>
    </div>
</body>
</html>











