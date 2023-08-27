window.onload=function(){
	initSelect();
	majDeckSize();
}

function click_carre(){
	var test = "deck_46846425"
	console.log(test.slice(0,5));
}

function assignId(idCard){
	if(document.getElementById("deck_1_" + idCard) === null){
		return "deck_1_" + idCard;
	} else if(document.getElementById("deck_2_" + idCard) === null){
		return "deck_2_" + idCard;
	} else {
		return "deck_3_" + idCard;
	}
}

function majDeckSize(){
	document.getElementById("deckSize").innerHTML = deckSize;
}

function testThreeCopies(carte){
	var twoOrMoreCopies = deck.filter((item, index) => deck.indexOf(item) !== index);
	var threeCopies = twoOrMoreCopies.filter((item, index) => twoOrMoreCopies.indexOf(item) !== index);
	if(threeCopies.indexOf(carte) === -1){
		return false;
	} else {
		return true;
	}
}

function countCopiesInDeck(carte){
	var nbCopies = 0;
	var twoOrMoreCopies = deck.filter((item, index) => deck.indexOf(item) !== index);
	var threeCopies = twoOrMoreCopies.filter((item, index) => twoOrMoreCopies.indexOf(item) !== index);
	if(threeCopies.indexOf(carte) !== -1){
		nbCopies = 3;
		return nbCopies;
	} else if(twoOrMoreCopies.indexOf(carte) !== -1){
		nbCopies = 2;
		return false;
	} else if(deck.indexOf(carte) !== -1){
		nbCopies = 1;
		return nbCopies;
	} else {
		return nbCopies;
	}
}

var loadedCards = [];

var deck = [];

var deckSize = 0;

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
	    bodyElt.innerHTML="";
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
	if(deckSize<40 && countCopiesInDeck(carte) < 3){
		let bodyElt = document.getElementById("deck_container");
		var img = document.createElement("img");
		img.src = carte.card_images[0].image_url;
		img.id = assignId(carte.id);
		img.className = "img_slot";
		img.setAttribute("oncontextmenu", "removeFromDeck(\"" + img.id + "\");return false;");
		img.setAttribute("onclick", "showDetail(\"" + img.id + "\")");
		img.style.animation = "created_in_deck 0.1s";
		bodyElt.appendChild(img);
		deck.push(carte);

		addCardAnimation(loadedId);
		deckSize += 1;
		majDeckSize();
	}
}

function showDetail(cardToShow){
	let carte;
	if(cardToShow.slice(0,5) === "deck_"){
		carte = deck.filter((item, index) => item.id === Number(cardToShow.split("_")[2]))[0];
	} else {
		carte = loadedCards[cardToShow];
	}
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

function removeFromDeck(id){
	let bodyElt = document.getElementById(id);
	bodyElt.style.animation = "removed_from_deck 0.04s";
	setTimeout(function(){bodyElt.remove()}, 40);
	carte = deck.filter((item, index) => item.id === Number(id.split("_")[2]))
	deck.splice(deck.indexOf(carte[0]), 1);

	deckSize -= 1;
	majDeckSize();
}