
var urlUsers = "http://localhost:8080/rp-web/user";
var xmlhttpUser = new XMLHttpRequest();

doEverything();


function doEverything(){

	xmlhttpUser.open("GET", urlUsers, true);
	xmlhttpUser.send();

	xmlhttpUser.onreadystatechange=function() {
		if (xmlhttpUser.status == 200) {
			getUsers(xmlhttpUser.responseText);
		}
	}	
}

function getUsers(response){	
	
	var response = xmlhttpUser.responseText;
	var leng = response.length;
	var formattedResp = response.substring(14,leng-1);
	
	var link = "<a href='./AJUUsuarioUnico.html?id="; 
	var arr = JSON.parse(formattedResp);
	var i;
	var out = "<table class='table'> <thead><tr><th>Nombre</th><th>Email</th><th>Phone</th><th>Company</th></tr></thead>";

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
	out += "</table>";
	document.getElementById("tablaUsuarios").innerHTML = out;
}
