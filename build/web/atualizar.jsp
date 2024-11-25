<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProdutoDAO" %>
<%@ page import="model.Produto" %>

<%
    Produto produt = (Produto) request.getAttribute("produto");
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
    <title>Atualizar Produto</title>
    <link rel="stylesheet" href="css/atualizar.css">
</head>
<body>
    <header>
        <h1>Atualizar Produto</h1>
    </header>

    <main>
        <form name = "frmatt" method="post" action="Atualizar">
            <div class="form-container">
                <p>Digite o ID do item que deseja atualizar:</p>
                <input name="id" placeholder="ID" id = "id"  required pattern="\d+" />
                <button type="submit">Buscar Produto</button>

                <% if (produt != null) { %>
                    <div class="form-fields">
                        <label>Descrição:</label>
                        <input name="descricao" value="<%= produt.getDescricao() %>" />

                        <label>Preço:</label>
                        <input name="preco" value="<%= produt.getPreco() %>" />

                        <label>Quantidade:</label>
                        <input name="quantidade" value="<%= produt.getQuantidade() %>" />

                        <label>Categoria:</label>
                        <input name="categoria" value="<%= produt.getCategoria() %>" />

                        <label>Marca:</label>
                        <input name="marca" value="<%= produt.getMarca() %>" />

                        <label>Peso:</label>
                        <input name="peso" value="<%= produt.getPeso() %>" />

                        <label>Validade:</label>
                        <input name="validade" type="date" value="<%= produt.getValidade() %>" />

                        <label>Cor:</label>
                        <input name="cor" value="<%= produt.getCor() %>" />

                        <label>Fornecedor:</label>
                        <input name="fornecedor" value="<%= produt.getFornecedor() %>" />
                    </div>
                <% } else { %>
                    <p>Produto não encontrado.</p>
                <% } %>
                <br>

                <button type="submit" >Atualizar</button>
            </div>
        </form>

        <h2>Produtos Disponíveis</h2>
        <table>
            <thead>
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
            </thead>
            <tbody>
                <% if (produtos != null) { %>
                    <% for (Produto produto : produtos) { %>
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
                    <% } %>
                <% } %>
            </tbody>
        </table>

        <div class="navigation-buttons">
            <button><a href="index.html">Início</a></button>
            <button><a href="cadastrar.jsp">Inserir Novo Produto</a></button>
         
        </div>
    </main>
            
</body>
</html>
