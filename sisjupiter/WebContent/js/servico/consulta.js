
function validaForm(){
    var focar;
    var texto;
    var divAviso = document.getElementById("divAviso");
    var aviso = document.getElementById("aviso");
    var valida = true;
    
    if (document.getElementById("dtInicio").value == ""
			&& document.getElementById("dtFim").value == ""
			&& document.getElementById("cpf").value == ""
			&& document.getElementById("rg").value == ""
			&& document.getElementById("comunidade").value == ""
			&& document.getElementById("endereco").value == "") {
    	texto = "Informe pelo menos um campo para consultar!";
    	focar = document.getElementById("cpf");
        valida = false;
	}
    else if (document.getElementById("dtInicio").value != ""
				&& document.getElementById("dtFim").value == "") {
    	texto = "Per&iacute;odo n&atilde;o informado corretamente!";
        focar = document.getElementById("dtFim");
        valida = false;
    }
    else if (document.getElementById("dtFim").value != ""
    	&& document.getElementById("dtInicio").value == "") {
    	texto = "Per&iacute;odo n&atilde;o informado corretamente!";
    	focar = document.getElementById("dtInicio");
    	valida = false;
    }
    else if(document.getElementById("cpf").value != "") {
    	if(!consistenciaCPF(document.getElementById("cpf").value)) {
	        texto = "CPF informado inv&aacute;lido!";
	        focar = document.getElementById("cpf");
	        valida = false;
    	}
    }
    
    if (valida == false) {
    	divAviso.style.display = "block";
        aviso.innerHTML = texto;
    	focar.focus();
        return false;
    }
}

function consistenciaCPF(campo) {
    cpf = campo.replace(/\./g, "").replace(/\-/g, "");
    erro = new String;

    if (cpf.length < 11)
        erro += "Por favor informe o CPF corretamente";
    var nonNumbers = /\D/;
    if (cpf === "00000000000" || cpf === "11111111111"
            || cpf === "22222222222" || cpf === "33333333333"
            || cpf === "44444444444" || cpf === "55555555555"
            || cpf === "66666666666" || cpf === "77777777777"
            || cpf === "88888888888" || cpf === "99999999999") {

        erro += "Numero de CPF invalido"
    }
    var a = [];
    var b = new Number;
    var c = 11;
    for (i = 0; i < 11; i++) {
        a[i] = cpf.charAt(i);
        if (i < 9)
            b += (a[i] * --c);
    }
    if ((x = b % 11) < 2) {
        a[9] = 0
    } else {
        a[9] = 11 - x
    }
    b = 0;
    c = 11;
    for (y = 0; y < 10; y++)
        b += (a[y] * c--);
    if ((x = b % 11) < 2) {
        a[10] = 0;
    } else {
        a[10] = 11 - x;
    }
    if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10])) {
        erro += "Numero de CPF invalido";
    }
    if (erro.length > 0) {
        return false;
    }
    else {
    	return true;
    }
}