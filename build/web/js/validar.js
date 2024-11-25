

function validar(){
    
   let descricao = frmproduto.descricao.value
   let preco = frmproduto.preco.value
   let quantidade = frmproduto.quantidade.value
   let categoria = frmproduto.categoria.value
   let marca = frmproduto.marca.value
   let peso = frmproduto.peso.value
  
   
   
   
   if ( descricao == null && preco == null && quantidade == null && categoria == null && marca == null && peso == null) {
       
       alert ("apenas os campos validade, cor e fornecedor podem estar em branco !")
       frmproduto.descricao.focus()
       return false
   }
    
   else if (preco < 0 ){
       
    alert ("o preco nao pode ser menor do que 0")
    frmproduto.preco.focus()
       return false
   }
   
    
}

//function validarAtt () {
//    
//    let id = frmatt.id.value
//    if (id == "") {
//        
//        alert ("o campo id deve ser preenchido")
//        frmatt.id.focus()
//        return false
//        
//    }


