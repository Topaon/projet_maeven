window.onload=function(){
	initSelect();
}

function click_carre(){
	let elt = document.getElementsByName("bozo")[0];
	console.log(elt.id);
}

var loadedCards = [];

function noContextMenu(){
	return false;
}

function filtreArchetype(){
	let bodyElt = document.getElementById("archetype-select");
	let filtre = "?archetype=" + bodyElt.value;
	getImages(filtre);
}

function initSelect(){
	let listArchetype = getListArchetypes();
	for(x in listArchetype){
		if(listArchetype[x].archetype){
			listArchetype.push(listArchetype[x].archetype);
		}
	}
	var unique = listArchetype.reduce((prev, cur) => (prev.indexOf(cur) === -1) ? [...prev, cur] : prev, []);
	let bodyElt = document.getElementById("archetype-select");
	for(x in unique){
		var opt = document.createElement("option");
		opt.text = unique[x];
		opt.value = unique[x];
		bodyElt.appendChild(opt);							
	}
}

function getImages(filtre){	
	let url = "https://db.ygoprodeck.com/api/v7/cardinfo.php" + filtre;
	makeAjaxGetRequest(url,function(responseJson){
		let data = JSON.parse(responseJson).data;
	    let bodyElt = document.getElementById("table_body");
	    bodyElt.innerHTML=""
		for(let x in data){
			var img = document.createElement("img");
			img.src = data[x].card_images[0].image_url;
			img.className = "img_slot";
			img.id = loadedCards.length;
			loadedCards.push(data[x]);
			img.setAttribute("oncontextmenu", "addToDeck(\"" + img.id + "\");return false;");
			img.setAttribute("onclick", "showDetail(\"" + img.id + "\")");			
			bodyElt.appendChild(img);
		}
   })
}

function addToDeck(loadedId){
	let carte = loadedCards[loadedId];
	let bodyElt = document.getElementById("deck_container");
	var img = document.createElement("img");
	img.src = carte.card_images[0].image_url;
	img.id = loadedId;
	img.name = "deck_" + img.id;
	img.className = "img_slot";
	img.setAttribute("oncontextmenu", "removeCard(\"" + img.name + "\");return false;");
	img.setAttribute("onclick", "showDetail(\"" + img.id + "\")");
	bodyElt.appendChild(img);
}

function showDetail(loadedId){
	let carte = loadedCards[loadedId];
	let bodyElt = document.getElementById("detail_container");
	bodyElt.innerHTML = "";
	
	var img = document.createElement("img");
	img.src = carte.card_images[0].image_url;
	img.id = carte.id;
	img.className = "img_detail";
	bodyElt.appendChild(img);
	
	var desc = document.createElement("p");
	desc.innerText = carte.desc;
	desc.id = "desc_text";
	bodyElt.appendChild(desc);
}

function removeCard(id){
	let bodyElt = document.getElementsByName(id)[0];
	bodyElt.remove();
}