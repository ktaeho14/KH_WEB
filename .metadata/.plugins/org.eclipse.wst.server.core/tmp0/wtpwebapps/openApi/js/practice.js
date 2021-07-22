var xhttp, xmlDoc, txt, x, i;
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function(){
	if(this.readyState ==4 && this.status ==200){
		xmlDoc = this.responseXML;
		txt = "";
		x = xmlDoc.getElementsByTagName('item');
		console.log(x);
		
		
		
		}
	};
xhttp.open("GET", "./xml/animal.xml", true);
xhttp.send();

