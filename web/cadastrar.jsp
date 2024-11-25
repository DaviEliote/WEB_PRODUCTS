<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produtos</title>
    <link rel="stylesheet" href="css/cadastro.css">
</head>
<body>
    <h1>Cadastro de Produtos</h1>
    
    <form name = "frmproduto" action="ProdutoServlet" method="post">
        <div class="containercadastrar"> 
            <label for="descricao">Descrição:</label>
            <input type="text" name="descricao" id="descricao" required>
            
            <label for="preco">Preço:</label>
            <input type="number" step="0.01" name="preco" id="preco" required>
            
            <label for="quantidade">Quantidade:</label>
            <input type="number" name="quantidade" id="quantidade" required>
            
            <label for="categoria">Categoria:</label>
            <input type="text" name="categoria" id="categoria" required>
            
            <label for="marca">Marca:</label>
            <input type="text" name="marca" id="marca" required>
            
            <label for="peso">Peso:</label>
            <input type="number" step="0.01" name="peso" id="peso" required>
            
            <label for="validade">Validade:</label>
            <input type="date" name="validade" id="validade" required>
            
            <label for="cor">Cor:</label>
            <input type="text" name="cor" id="cor">
            
            <label for="fornecedor">Fornecedor:</label>
            <input type="text" name="fornecedor" id="fornecedor">
            
            <button class="btn" type="submit" onclick = "validar()">Salvar Produto</button>
        </div>
    </form>
    
    <div class="cadastrar2">
        <button class="btn"><a href="listar.jsp">Listar Produtos</a></button>
        <button class="btn"><a href="listar_por_id.jsp">Consultar por ID</a></button>
    </div>
    <script src = "js/validar.js"> </script>
</body>
</html>

