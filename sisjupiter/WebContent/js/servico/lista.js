
function paginarProximo() {
    
    var dtInicio = document.getElementById('dtInicio');
    var dtFim = document.getElementById('dtFim');
    var cpf = document.getElementById('cpf');
    var rg = document.getElementById('rg');
    var comuinidade = document.getElementById('comuinidade');
    var endereco = document.getElementById('endereco');
    var inicio = new Number(document.getElementById('inicio').value);
    var fim = new Number(document.getElementById('fim').value);
    var paginaAtual = new Number(document.getElementById('paginaAtual').value);
    var qtdePaginas = new Number(document.getElementById('qtdePaginas').value);
    var divTable = document.getElementById('divTable');
    var divPaginacao = document.getElementById('divPaginacao');
    
    inicio = fim+1;
    fim = fim+50;
    paginaAtual++;
    document.getElementById('inicio').value = inicio;
    document.getElementById('fim').value = fim;
    document.getElementById('paginaAtual').value = paginaAtual;
    
    
    $.blockUI({message: '<h1> Aguarde...</h1>'});
    $.ajax({
        url: 'DiagnosticoBO?acao=paginacao' +
             '&dtInicio=' + dtInicio.value +
             '&dtFim=' + dtFim.value +
             '&cpf=' + cpf.value +
             '&rg=' + rg.value +
             '&comunidade=' + comunidade.value +
             '&endereco=' + endereco.value +
             '&inicio=' + inicio +
             '&fim=' + fim +
             '&anterior=false'
        ,
        type: "POST",
        dataType: 'json',
        success: function(result){

            var texto = '';
            var lista = result;
        	texto=	"<table class='table table-hover table-striped'>" +
					"	<thead>" +
					"		<tr>" +
					"			<th style='width:0.5%;'>Nº</th>" +
					"			<th style='width:15%;'>Cliente</th>" +
					"			<th style='width:11%;'>CPF</th>" +
					"			<th style='width:11%;'>RG</th>" +
					"			<th style='width:25%;'>Comunidade</th>" +
					"			<th style='width:25%;'>Endere&ccedil;o</th>" +
					"			<th style='width:11%;'>Data Execu&ccedil;&atilde;o</th>" +
					"			<th></th>" +
					"		</tr>" +
					"	</thead>" +
					"	<tbody id='myTable'>";
        	
			for(i = 0; i < lista.length; i++){
				var item = lista[i];
				texto +="<tr>" +
				"			<td>"+(inicio++)+"</td>" +
				"			<td><small>"+item.nomeCliente+"</small></td>" +
				"			<td><small>"+item.cpf+"</small></td>" +
				"			<td><small>"+item.rg+"</small></td>" +
				"			<td><small>"+item.nomeComunidade+"</small></td>" +
				"			<td><small>"+item.endereco+"</small></td>" +
				"			<td><small>"+item.dataExecucao+"</small></td>" +
				"           <td>" +
				"				<a href='DiagnosticoBO?acao=detalhe&id="+item.idDiagnostico+"&dtInicio="+dtInicio.value+"&dtFim="+dtFim.value+"&cpf="+cpf.value+"&rg="+rg.value+"&endereco="+endereco.value+"&comunidade="+comunidade.value+"&inicio="+inicio.value+"&fim="+fim.value+"'>" +
				"					<button type='button' class='btn btn-info btn-sm' title='Clique para visualizar o detalhe do serviço'>" +
				"						<span class='glyphicon glyphicon-search'></span>" +
				"					</button>" +
				"				</a>" +
				"			</td>" +
				"		</tr>";
			}
			texto+=	"	</tbody>" +
					"</table>";

            divTable.innerHTML = texto;
            
            
            texto = "	<ul class='pagination'>";
			if(paginaAtual == 1) {
				texto+="		<li class='previous disabled'><a href='#'>Anterior</a></li>";
			}
			else {
				texto+="		<li class='previous'><a href='javascript:void(0)' onclick='paginarAnterior();'>Anterior</a></li>";
			}
			
			for(i = 1; i <= qtdePaginas; i++){
				if(paginaAtual == i){
					texto+= "<li class='active'><a href='javascript:void(0)' onclick='paginar("+i+");'>"+i+"</a></li>";
				}
				else {
					texto+= "<li><a href='javascript:void(0)' onclick='paginar("+i+");'>"+i+"</a></li>";
				}
			}
			
			if(paginaAtual == qtdePaginas) {
				texto+="	  	<li class='next' disabled><a href='javascript:void(0)' onclick='paginarProximo();'>Próximo</a></li>";
			}
			else {
				texto+="	  	<li class='next'><a href='javascript:void(0)' onclick='paginarProximo();'>Próximo</a></li>";
			}
			texto+="	</ul>";
            
			divPaginacao.innerHTML = texto;
            

            $.unblockUI();
        },
        error : function(){

            $.unblockUI();
            alert('erro');
        }
    });
}

function paginarAnterior() {
    
    var dtInicio = document.getElementById('dtInicio');
    var dtFim = document.getElementById('dtFim');
    var cpf = document.getElementById('cpf');
    var rg = document.getElementById('rg');
    var comuinidade = document.getElementById('comuinidade');
    var endereco = document.getElementById('endereco');
    var inicio = new Number(document.getElementById('inicio').value);
    var fim = new Number(document.getElementById('fim').value);
    var paginaAtual = new Number(document.getElementById('paginaAtual').value);
    var qtdePaginas = new Number(document.getElementById('qtdePaginas').value);
    var divTable = document.getElementById('divTable');
    var divPaginacao = document.getElementById('divPaginacao');
    
    paginaAtual--;
    if(paginaAtual == 1) {
    	inicio = 1;
    	fim = 50;
    }
    else {
    	inicio = inicio-50;
    	fim = fim-50;
    }
    document.getElementById('inicio').value = inicio;
    document.getElementById('fim').value = fim;
    document.getElementById('paginaAtual').value = paginaAtual;
    
    
    $.blockUI({message: '<h1> Aguarde...</h1>'});
    $.ajax({
        url: 'DiagnosticoBO?acao=paginacao' +
             '&dtInicio=' + dtInicio.value +
             '&dtFim=' + dtFim.value +
             '&cpf=' + cpf.value +
             '&rg=' + rg.value +
             '&comunidade=' + comunidade.value +
             '&endereco=' + endereco.value +
             '&inicio=' + inicio +
             '&fim=' + fim +
             '&anterior=false'
        ,
        type: "POST",
        dataType: 'json',
        success: function(result){

            var texto = '';
            var lista = result;
        	texto=	"<table class='table table-hover table-striped'>" +
					"	<thead>" +
					"		<tr>" +
					"			<th style='width:0.5%;'>Nº</th>" +
					"			<th style='width:15%;'>Cliente</th>" +
					"			<th style='width:11%;'>CPF</th>" +
					"			<th style='width:11%;'>RG</th>" +
					"			<th style='width:25%;'>Comunidade</th>" +
					"			<th style='width:25%;'>Endere&ccedil;o</th>" +
					"			<th style='width:11%;'>Data Execu&ccedil;&atilde;o</th>" +
					"			<th></th>" +
					"		</tr>" +
					"	</thead>" +
					"	<tbody id='myTable'>";
        	
			for(i = 0; i < lista.length; i++){
				var item = lista[i];
				texto +="<tr>" +
				"			<td>"+(inicio++)+"</td>" +
				"			<td><small>"+item.nomeCliente+"</small></td>" +
				"			<td><small>"+item.cpf+"</small></td>" +
				"			<td><small>"+item.rg+"</small></td>" +
				"			<td><small>"+item.nomeComunidade+"</small></td>" +
				"			<td><small>"+item.endereco+"</small></td>" +
				"			<td><small>"+item.dataExecucao+"</small></td>" +
				"           <td>" +
				"				<a href='DiagnosticoBO?acao=detalhe&id="+item.idDiagnostico+"&dtInicio="+dtInicio+"&dtFim="+dtFim+"&cpf="+cpf+"&rg="+rg+"&endereco="+endereco+"&comunidade="+comunidade+"&inicio="+inicio+"&fim="+fim+"'>" +
				"					<button type='button' class='btn btn-info btn-sm' title='Clique para visualizar o detalhe do serviço'>" +
				"						<span class='glyphicon glyphicon-search'></span>" +
				"					</button>" +
				"				</a>" +
				"			</td>" +
				"		</tr>";
			}
			texto+=	"	</tbody>" +
					"</table>";

            divTable.innerHTML = texto;
            
            
            texto = "	<ul class='pagination'>";
			if(paginaAtual == 1) {
				texto+="		<li class='previous disabled'><a href='#'>Anterior</a></li>";
			}
			else {
				texto+="		<li class='previous'><a href='javascript:void(0)' onclick='paginarAnterior();'>Anterior</a></li>";
			}
			
			for(i = 1; i <= qtdePaginas; i++){
				if(paginaAtual == i){
					texto+= "<li class='active'><a href='javascript:void(0)' onclick='paginar("+i+");'>"+i+"</a></li>";
				}
				else {
					texto+= "<li><a href='javascript:void(0)' onclick='paginar("+i+");'>"+i+"</a></li>";
				}
			}
			
			if(paginaAtual == qtdePaginas) {
				texto+="	  	<li class='next' disabled><a href='javascript:void(0)' onclick='paginarProximo();'>Próximo</a></li>";
			}
			else {
				texto+="	  	<li class='next'><a href='javascript:void(0)' onclick='paginarProximo();'>Próximo</a></li>";
			}
			texto+="	</ul>";
            
			divPaginacao.innerHTML = texto;
            

            $.unblockUI();
        },
        error : function(){

            $.unblockUI();
            alert('erro');
        }
    });
}

function paginar(valor) {
    
    var dtInicio = document.getElementById('dtInicio');
    var dtFim = document.getElementById('dtFim');
    var cpf = document.getElementById('cpf');
    var rg = document.getElementById('rg');
    var comuinidade = document.getElementById('comuinidade');
    var endereco = document.getElementById('endereco');
    var inicio = new Number(document.getElementById('inicio').value);
    var fim = new Number(document.getElementById('fim').value);
    var paginaAtual = new Number(document.getElementById('paginaAtual').value);
    var qtdePaginas = new Number(document.getElementById('qtdePaginas').value);
    var divTable = document.getElementById('divTable');
    var divPaginacao = document.getElementById('divPaginacao');
    
    
    inicio = (valor*50)-49;
    fim = (valor*50);
    paginaAtual = valor;
    document.getElementById('inicio').value = inicio;
    document.getElementById('fim').value = fim;
    document.getElementById('paginaAtual').value = paginaAtual;
    
    
    $.blockUI({message: '<h1> Aguarde...</h1>'});
    $.ajax({
        url: 'DiagnosticoBO?acao=paginacao' +
             '&dtInicio=' + dtInicio.value +
             '&dtFim=' + dtFim.value +
             '&cpf=' + cpf.value +
             '&rg=' + rg.value +
             '&comunidade=' + comunidade.value +
             '&endereco=' + endereco.value +
             '&inicio=' + inicio +
             '&fim=' + fim +
             '&anterior=false'
        ,
        type: "POST",
        dataType: 'json',
        success: function(result){

            var texto = '';
            var lista = result;
        	texto=	"<table class='table table-hover table-striped'>" +
					"	<thead>" +
					"		<tr>" +
					"			<th style='width:0.5%;'>Nº</th>" +
					"			<th style='width:15%;'>Cliente</th>" +
					"			<th style='width:11%;'>CPF</th>" +
					"			<th style='width:11%;'>RG</th>" +
					"			<th style='width:25%;'>Comunidade</th>" +
					"			<th style='width:25%;'>Endere&ccedil;o</th>" +
					"			<th style='width:11%;'>Data Execu&ccedil;&atilde;o</th>" +
					"			<th></th>" +
					"		</tr>" +
					"	</thead>" +
					"	<tbody id='myTable'>";
        	
			for(i = 0; i < lista.length; i++){
				var item = lista[i];
				texto +="<tr>" +
				"			<td>"+(inicio++)+"</td>" +
				"			<td><small>"+item.nomeCliente+"</small></td>" +
				"			<td><small>"+item.cpf+"</small></td>" +
				"			<td><small>"+item.rg+"</small></td>" +
				"			<td><small>"+item.nomeComunidade+"</small></td>" +
				"			<td><small>"+item.endereco+"</small></td>" +
				"			<td><small>"+item.dataExecucao+"</small></td>" +
				"           <td>" +
				"				<a href='DiagnosticoBO?acao=detalhe&id="+item.idDiagnostico+"&dtInicio="+dtInicio+"&dtFim="+dtFim+"&cpf="+cpf+"&rg="+rg+"&endereco="+endereco+"&comunidade="+comunidade+"&inicio="+inicio+"&fim="+fim+"'>" +
				"					<button type='button' class='btn btn-info btn-sm' title='Clique para visualizar o detalhe do serviço'>" +
				"						<span class='glyphicon glyphicon-search'></span>" +
				"					</button>" +
				"				</a>" +
				"			</td>" +
				"		</tr>";
			}
			texto+=	"	</tbody>" +
					"</table>";

            divTable.innerHTML = texto;
            
            
            texto = "	<ul class='pagination'>";
			if(paginaAtual == 1) {
				texto+="		<li class='previous disabled'><a href='#'>Anterior</a></li>";
			}
			else {
				texto+="		<li class='previous'><a href='javascript:void(0)' onclick='paginarAnterior();'>Anterior</a></li>";
			}
			
			for(i = 1; i <= qtdePaginas; i++){
				if(paginaAtual == i){
					texto+= "<li class='active'><a href='javascript:void(0)' onclick='paginar("+i+");'>"+i+"</a></li>";
				}
				else {
					texto+= "<li><a href='javascript:void(0)' onclick='paginar("+i+");'>"+i+"</a></li>";
				}
			}
			
			if(paginaAtual == qtdePaginas) {
				texto+="	  	<li class='next disabled'><a href='#'>Próximo</a></li>";
			}
			else {
				texto+="	  	<li class='next'><a href='javascript:void(0)' onclick='paginarProximo();'>Próximo</a></li>";
			}
			texto+="	</ul>";
            
			divPaginacao.innerHTML = texto;
            

            $.unblockUI();
        },
        error : function(){

            $.unblockUI();
            alert('erro');
        }
    });
}

