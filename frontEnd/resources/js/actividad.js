
var urlActividades = "http://localhost:8080/rp-web/activity";
var xmlhttpActividades = new XMLHttpRequest();
	
doEverything();

setInterval(doEverything, 1000); // Time in milliseconds

function doEverything(){

	xmlhttpActividades.open("GET", urlActividades, true);
	xmlhttpActividades.send();

	xmlhttpActividades.onreadystatechange=function() {
		if (xmlhttpActividades.status == 200) {
			getActividades(xmlhttpActividades.responseText);
		}
	}	
}


function getActividades(response) {
	
	var leng = response.length;
	var formattedResp = response.substring(14,leng-1);
	
    var arr = JSON.parse(formattedResp);
    var i;
    var out = "<table class='table'> <thead><tr><th>Usuario</th><th>Equipo</th><th>Fecha</th><th>Actividad</th></tr></thead>";

	var link = "<a href='./AJUActividadUnica.html?id="; 
	//var ending = "'>" </a>"
	
	
    for(i = 0; i < arr.length; i++) {
		
		var enteringString = arr[i].entering+"";
		var estaEntrando = enteringString.toUpperCase() === "true".toUpperCase();
		
		var entr = "Saliendo";
		if (estaEntrando){
			entr = "Entrando";
		}
        out += "<tr><td>" +link+arr[i].id + "'>"+ arr[i].user+" </a>"+
        "</td><td>" +
        link+arr[i].id + "'>"+ arr[i].equipment +" </a>"+
		"</td><td>" +
		link+arr[i].id + "'>"+ arr[i].date +" </a>"+
		"</td><td>" +
		link+arr[i].id + "'>"+ entr +" </a>"+
        "</td></tr>";
    }
    out += "</table>";
    document.getElementById("tablaActividades").innerHTML = out;
	
}

function goBack() {
	window.history.back();
}



