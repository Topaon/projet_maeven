window.onload=function(){
	initSelect();
}

function filtreArchetype(){
	let bodyElt = document.getElementById("archetype-select");
	let filtre = "?archetype=" + bodyElt.value;
	console.log(bodyElt.value);
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
			console.log("nom de la carte : " + data[x].name);
			img.className = "img_slot";
			img.id = x;
			img.setAttribute("onclick", "addToDeck(\"" + data[x].id + "\")");
				console.log(data[x]);
				console.log(img.width);
//			if(img.width==168 && img.height==246){
				bodyElt.appendChild(img);
//			}
		}
   })
}

function addToDeck(id){
	let url = "https://db.ygoprodeck.com/api/v7/cardinfo.php?id=" + id;
	makeAjaxGetRequest(url,function(responseJson){
		let carte = JSON.parse(responseJson).data;
		let bodyElt = document.getElementById("deck_container");
		var img = document.createElement("img");
		img.src = carte[0].card_images[0].image_url;
		img.id = carte[0].id;
		img.className = "img_slot";
		img.setAttribute("onclick", "removeFromDeck(\"" + img.id + "\")");
		bodyElt.appendChild(img);
	})
}

function removeFromDeck(id){
	let bodyElt = document.getElementById(id);
	bodyElt.remove();
}