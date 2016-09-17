

var urlCompanies = "http://localhost:8080/rp-web/company";
var urlEquipments = "http://localhost:8080/rp-web/equipment";
var urlLocations = "http://localhost:8080/rp-web/location";


var xmlhttpCompanies = new XMLHttpRequest();
xmlhttpCompanies.open("GET", urlCompanies, true);
xmlhttpCompanies.send();

xmlhttpCompanies.onreadystatechange=function() {
    if (xmlhttpCompanies.status == 200) {
        getCompanies(xmlhttpCompanies.responseText);
    }
}


var xmlhttpEquipment = new XMLHttpRequest();
xmlhttpEquipment.open("GET", urlEquipments, true);
xmlhttpEquipment.send();

xmlhttpEquipment.onreadystatechange=function() {
    if (xmlhttpEquipment.status == 200) {
        getEquipments(xmlhttpEquipment.responseText);
    }
}

var xmlhttpLocation = new XMLHttpRequest();
xmlhttpLocation.open("GET", urlLocations, true);
xmlhttpLocation.send();

xmlhttpLocation.onreadystatechange=function() {
    if (xmlhttpLocation.status == 200) {
        getLocations(xmlhttpLocation.responseText);
    }
}




function getCompanies(response) {
	
	var leng = response.length;
	var formattedResp = response.substring(14,leng-1);
	
    var arr = JSON.parse(formattedResp);
    var i;
    var out = "<table class='table'> <thead><tr><th>Nombre</th><th>Id localización</th></tr></thead>";

    for(i = 0; i < arr.length; i++) {
        out += "<tr><td>" +
        arr[i].name +
        "</td><td>" +
        arr[i].locationId +
        "</td></tr>";
    }
    out += "</table>";
    document.getElementById("tablaCompanias").innerHTML = out;
	
}


function getEquipments(response){	

	var leng = response.length;
	var formattedResp = response.substring(14,leng-1);
	
	var arr = JSON.parse(formattedResp);
	var i;
	var out = "<table class='table'> <thead><tr><th>Id localización</th><th>Estado</th></tr></thead>";

	for(i = 0; i < arr.length; i++) {
		out += "<tr><td>" +
		arr[i].locationID +
		"</td><td>" +
		arr[i].status +
		"</td></tr>";
	}
	out += "</table>";
	document.getElementById("tablaEquipos").innerHTML = out;
		
}

function getLocations(response){
	
	var response = xmlhttpLocation.responseText;
	var leng = response.length;
	var formattedResp = response.substring(14,leng-1);
	
	var arr = JSON.parse(formattedResp);
	var i;
	var out = "<table class='table'> <thead><tr><th>Id</th><th>Nombre</th><th>Pertenece a</th></tr></thead>";

	for(i = 0; i < arr.length; i++) {
		out += "<tr><td>" +
		arr[i].id +
		"</td><td>" +			
		arr[i].name +
		"</td><td>" +			
		arr[i].locationId +
		"</td></tr>";
	}
	out += "</table>";
	document.getElementById("tablaLocations").innerHTML = out;	
}
