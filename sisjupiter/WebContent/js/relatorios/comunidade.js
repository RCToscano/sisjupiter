
function gerarExcel() {
    
    $.blockUI({message: '<h1> Aguarde...</h1>'});
    $.ajax({
        url: 'RelComunidadeBO?acao=excelTotalDiag' 
        ,
        type: "POST",
        dataType: 'json',
        success: function(result){
            $.unblockUI();
        },
        error : function(){

            $.unblockUI();
            alert('Não foi possível gerar o excel');
        }
    });
}


