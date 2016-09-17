

var urlusuarios = "http://localhost:8080/rp-web/user";
var xmlhttpusuarios = new XMLHttpRequest();
	


var myParam = location.search.split('id=')[1]
	
urlusuarios = urlusuarios +"/"+myParam;	
doEverything();


function doEverything(){

	xmlhttpusuarios.open("GET", urlusuarios, true);
	xmlhttpusuarios.send();

	xmlhttpusuarios.onreadystatechange=function() {
		if (xmlhttpusuarios.status == 200) {
			getusuarios(xmlhttpusuarios.responseText);
		}
	}	
}

function getusuarios(response) {	
	
    var arr = JSON.parse(response);
    var i;
    var out = "<table class='table'> <thead><tr><th>Nombre</th><th>Email</th><th>Phone</th><th>Company</th></tr></thead>";
    
		
	var enteringString = arr.entering+"";
	var estaEntrando = enteringString.toUpperCase() === "true".toUpperCase();
	
	var entr = "Saliendo";
	if (estaEntrando){
		entr = "Entrando";
	}
	
	
	for(i = 0; i < arr.length; i++) {
		out += "<tr><td>" +
		link+arr[i].id + "'>"+ arr[i].name +" </a>"+
		"</td><td>" +			
		link+arr[i].id + "'>"+ arr[i].email +" </a>"+
		"</td><td>" +			
		link+arr[i].id + "'>"+ arr[i].phone +" </a>"+
		"</td><td>" +			
		link+arr[i].id + "'>"+ arr[i].companyId +" </a>"+
		"</td></tr>";
		}
	
	out += "<tr><td>" +
	arr.name +
	"</td><td>" +
	arr.email +
	"</td><td>" +
	arr.phone +
	"</td><td>" +
	arr.companyId +	
	"</td></tr>";

    out += "</table>";
    document.getElementById("tablausuarios").innerHTML = out;	
}

function goBack() {
	window.history.back();
}



