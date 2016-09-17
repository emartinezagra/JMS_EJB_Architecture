

var urlActividades = "http://localhost:8080/rp-web/activity";
var xmlhttpActividades = new XMLHttpRequest();
	


var myParam = location.search.split('id=')[1]
	
urlActividades = urlActividades +"/"+myParam;	
doEverything();


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
	
    var arr = JSON.parse(response);
    var i;
    var out = "<table class='table'> <thead><tr><th>Usuario</th><th>Equipo</th><th>Fecha</th><th>Actividad</th></tr></thead>";
    
		
	var enteringString = arr.entering+"";
	var estaEntrando = enteringString.toUpperCase() === "true".toUpperCase();
	
	var entr = "Saliendo";
	if (estaEntrando){
		entr = "Entrando";
	}
	out += "<tr><td>" +
	arr.user +
	"</td><td>" +
	arr.equipment +
	"</td><td>" +
	arr.date +
	"</td><td>" +
	entr +
	"</td></tr>";

    out += "</table>";
    document.getElementById("tablaActividades").innerHTML = out;	
}

function goBack() {
	window.history.back();
}



