window.onload=function(){
	(document.getElementById("btnRecherche"))
	   .addEventListener("click",rechercherDevisesSelonCode);

}
	
function rechercherDevisesSelonCode(){	
	let code = (document.getElementById("inputCode")).value;
	
	let wsUrl = "./api-devise/devise/"+code;
	
	makeAjaxGetRequest(wsUrl,function(responseJson){
		let devisesJs = JSON.parse(responseJson);
		console.log("devisesJs="+devisesJs);
		
		let bodyElt = document.getElementById("spanMsg");
		bodyElt.innerHTML=devisesJs;
	});
}