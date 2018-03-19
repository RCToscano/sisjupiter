
window.onload = function iniciarForm() {

	if(document.getElementById("ensino6").checked === false){
		var radios = document.getElementsByName('radioConsegueLer');
		for (var i = 0; i< radios.length;  i++){
			radios[i].disabled = true;
		}
		radios = document.getElementsByName('radioConsegueEscrever');
		for (var i = 0; i< radios.length;  i++){
			radios[i].disabled = true;
		}
	}
}

function validaForm(){
    var focar;
    var texto;
    var divAviso = document.getElementById("divAviso");
    var aviso = document.getElementById("aviso");
    var valida = true;
    
    
    if(document.getElementById("rgi").value === ""){
        texto = "Favor informar o rgi!";
        focar = document.getElementById("rgi");
        valida = false;
    }
    
    if (valida == false) {
    	document.getElementById("divEfluDomestico").style.display = "block";
        aviso.innerHTML = texto;
        focar.focus();
        return false;
    }
}

function verificaAnalfabeto() {
	if(document.getElementById("ensino6").checked === true){
		var radios = document.getElementsByName('radioConsegueLer');
		for (var i = 0; i< radios.length;  i++){
			radios[i].disabled = false;
		}
		radios = document.getElementsByName('radioConsegueEscrever');
		for (var i = 0; i< radios.length;  i++){
			radios[i].disabled = false;
		}
	}
	else {
		var radios = document.getElementsByName('radioConsegueLer');
		for (var i = 0; i< radios.length;  i++){
			radios[i].disabled = true;
		}
		radios = document.getElementsByName('radioConsegueEscrever');
		for (var i = 0; i< radios.length;  i++){
			radios[i].disabled = true;
		}
	}
}

function moeda(z){ 
	if ((event.keyCode < 48) || (event.keyCode > 57)) {
        if ((event.keyCode == 13)) {
        }
        else {
            event.returnValue = false;
        }
    }
	else {
    	v = z.value; 
    	v=v.replace(/\D/g,"") // permite digitar apenas numero 
    	v=v.replace(/(\d{1})(\d{15})$/,"$1.$2") // coloca ponto antes dos ultimos digitos 
    	v=v.replace(/(\d{1})(\d{11})$/,"$1.$2") // coloca ponto antes dos ultimos 13 digitos 
    	v=v.replace(/(\d{1})(\d{8})$/,"$1.$2") // coloca ponto antes dos ultimos 10 digitos 
    	v=v.replace(/(\d{1})(\d{5})$/,"$1.$2") // coloca ponto antes dos ultimos 7 digitos 
    	v=v.replace(/(\d{1})(\d{1,2})$/,"$1,$2") // coloca virgula antes dos ultimos 4 digitos 
    	z.value = v; 
	}
	
}

function consistenciaCPF(campo) {
    var aviso = document.getElementById("aviso");
    aviso.innerHTML = "";
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
        aviso.innerHTML = erro;
        return false;
    }
}