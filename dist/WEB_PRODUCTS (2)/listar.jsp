<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProdutoDAO" %>
<%@ page import="controller.Produto" %>

<%
    ProdutoDAO dao = new ProdutoDAO();
    List<Produto> produtos = new ArrayList<>();
    try {
        produtos = dao.consultarTodos();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <link rel="stylesheet" href="css/listar.css">
</head>
<body>
    <header>
        <h1>Lista de Produtos</h1>
    </header>

    <main>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                    <th>Quantidade</th>
                    <th>Peso</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (produtos != null) {
                        for (Produto produto : produtos) {
                %>
                <tr>
                    <td><%= produto.getId() %></td>
                    <td><%= produto.getDescricao() %></td>
                    <td>R$ <%= produto.getPreco() %></td>
                    <td><%= produto.getQuantidade() %></td>
                    <td><%= produto.getPeso() %> kg</td>
                    <td>
                        <form method="post" action="Delete" class="action-form">
                            <button type="submit" name="id" value="<%= produto.getId() %>">
                                <img src="images/delete.png" width="20" height="20" alt="Deletar">
                            </button>
                        </form>
                        <a href="atualizar.jsp?id=<%= produto.getId() %>" class="action-link">
                            <img src="images/edit.png" width="20" height="20" alt="Editar">
                        </a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>

        <div class="navigation-buttons">
            <button><a href="index.html">Início</a></button>
            <button><a href="cadastrar.jsp">Inserir Novo Produto</a></button>
        </div>
    </main>
</body>
</html>
