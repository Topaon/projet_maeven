window.onload=function(){
	initSelect();
	majDeckSize();
}

function click_carre(){
	console.log(deck)
}

var loadedCards = [];

var deck = [];

var extraDeck = [];

function assignId(idCard, deckType){
	if(document.getElementById(deckType + "_1_" + idCard) === null){
		return deckType + "_1_" + idCard;
	} else if(document.getElementById(deckType + "_2_" + idCard) === null){
		return deckType + "_2_" + idCard;
	} else {
		return deckType + "_3_" + idCard;
	}
}

function sortByCardType(cardList){

	sortedCardList = cardList.sort(function(a,b) {

		switch(a.frameType.split("_")[0]){
			case "normal": a = 0; break;
			case "effect": a = 1; break;
			case "ritual": a = 2; break;
			case "spell": a = 3; break;
			case "trap": a = 4; break;
			case "fusion": a = 5; break;
			case "synchro": a = 6; break;
			case "xyz": a = 7; break;
			case "pendulum": a = 8; break;
			case "link": a = 9; break;
		}

		switch(b.frameType.split("_")[0]){
			case "normal": b = 0; break;
			case "effect": b = 1; break;
			case "ritual": a = 2; break;
			case "spell": b = 3; break;
			case "trap": b = 4; break;
			case "fusion": b = 5; break;
			case "synchro": b = 6; break;
			case "xyz": b = 7; break;
			case "pendulum": b = 8; break;
			case "link": b = 9; break;
		}

		if(a<b){
			return -1;
		} else if(a>b){
			return 1;
		} else {
			return 0
		}
	})

	return sortedCardList;
}

function majDeckSize(){
	/*
	document.getElementById("deckSize").innerHTML = deck.length;
	document.getElementById("extraDeckSize").innerHTML = extraDeck.length;
	*/
}

function countCopiesInDeck(carte, deckType){
	var carteType = carte.type.split(" ");
	var nbCopies = 0;
	var twoOrMoreCopies = deckType.filter((item, index) => deckType.indexOf(item) !== index);
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

function initSelect(){
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

function getImages(data){
	let bodyElt = document.getElementById("table_body");
	bodyElt.innerHTML="";
	data = sortByCardType(data)
	for(let x in data){
		var img = document.createElement("img");
		img.src = "img/card_img_database/" + data[x].id + ".jpg";
		img.className = "img_slot";
		img.id = loadedCards.length;
		loadedCards.push(data[x]);
		img.setAttribute("oncontextmenu", "addToDeck(\"" + img.id + "\");return false;");
		img.setAttribute("onmouseover", "showDetail(\"" + img.id + "\")");
		bodyElt.appendChild(img);
	}
}

function addToDeck(loadedId){
	let carte = loadedCards[loadedId];
	var carteType = carte.type.split(" ");
	if(
		carteType.indexOf("Fusion") !== -1 ||
		carteType.indexOf("Synchro") !== -1 ||
		carteType.indexOf("XYZ") !== -1 ||
		carteType.indexOf("Link") !== -1
	){
		if(extraDeck.length<15 && countCopiesInDeck(carte, extraDeck) < 3){
			let bodyElt = document.getElementById("extra_deck_container");
			var img = document.createElement("img");
			img.src = carte.card_images[0].image_url;
			img.id = assignId(carte.id, "extraDeck");
			img.className = "img_slot";
			img.setAttribute("oncontextmenu", "removeFromDeck(\"" + img.id + "\", \"extraDeck\");return false;");
			img.setAttribute("onclick", "showDetail(\"" + img.id + "\")");
			img.style.animation = "created_in_deck 0.1s";
			bodyElt.appendChild(img);
			extraDeck.push(carte);

			addCardAnimation(loadedId);
			majDeckSize();
		}
	} else {
		if(deck.length<40 && countCopiesInDeck(carte, deck) < 3){
			let bodyElt = document.getElementById("deck_container");
			var img = document.createElement("img");
			img.src = carte.card_images[0].image_url;
			img.id = assignId(carte.id, "deck");
			img.className = "img_slot";
			img.setAttribute("oncontextmenu", "removeFromDeck(\"" + img.id + "\", \"deck\");return false;");
			img.setAttribute("onclick", "showDetail(\"" + img.id + "\")");
			img.style.animation = "created_in_deck 0.1s";
			bodyElt.appendChild(img);
			deck.push(carte);

			addCardAnimation(loadedId);
			majDeckSize();
		}
	}
}

function removeFromDeck(id, deckType){
	let bodyElt = document.getElementById(id);
	bodyElt.style.animation = "removed_from_deck 0.04s";
	setTimeout(function(){bodyElt.remove()}, 40);
	
	if(deckType === "deck"){
		carte = deck.filter((item, index) => item.id === Number(id.split("_")[2]))
		deck.splice(deck.indexOf(carte[0]), 1);
	} else if(deckType === "extraDeck") {
		carte = extraDeck.filter((item, index) => item.id === Number(id.split("_")[2]))
		extraDeck.splice(extraDeck.indexOf(carte[0]), 1);
	}
	
	majDeckSize();
}

function showDetail(cardToShow){
	let carte;
	if(cardToShow.split("_")[0] === "deck"){
		carte = deck.filter((item, index) => item.id === Number(cardToShow.split("_")[2]))[0];
	} else if(cardToShow.split("_")[0] === "extraDeck"){
		carte = extraDeck.filter((item, index) => item.id === Number(cardToShow.split("_")[2]))[0];
	} else {
		carte = loadedCards[cardToShow];
	}
	let bodyElt = document.getElementById("detail_container");
	bodyElt.innerHTML = "";

	var img = document.createElement("img");
	img.src = carte.card_images[0].image_url;
	img.id = carte.id;
	img.className = "img_detail";
	img.setAttribute("oncontextmenu", "addToDeck(\"" + cardToShow + "\");return false;");
	bodyElt.appendChild(img);

	var desc = document.createElement("p");
	desc.innerText = carte.desc;
	desc.id = "desc_text";
	bodyElt.appendChild(desc);
}

function chercherCarteParNom(){
	var name = document.getElementById("input_search_card").value;
	if(name.length > 2) {
		var data = cardDataBase.filter((item) => item.name.toLowerCase().includes(name.toLowerCase()));
		getImages(data)
	} else if(name.length == 0) {
		getImages("")
	}
}

function chercherCarteParArchetype(){
	let bodyElt = document.getElementById("archetype-select");
	let archetype = bodyElt.value;
	var data = cardDataBase.filter((item) => item.archetype == archetype);
	getImages(data)
}