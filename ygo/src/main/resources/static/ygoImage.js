window.onload=function(){
	getImages();
}

function getImages(){
	fetch("https://db.ygoprodeck.com/api/v7/cardinfo.php?archetype=Kashtira", {
   headers: {
      'Accept': 'application/json'
   }
})
   .then(response => response.text())
   .then(text => JSON.parse(text).data)
   .then(data => {
	   let bodyElt = document.getElementById("table_body");
		bodyElt.innerHT="";//vider le tableau avant de le re-remplir
		for(let x in data){
			let row = bodyElt.insertRow(-1);
			let cell = row.insertCell(0);
			
			var img = document.createElement('img');
			img.src = data[x].card_images[0].image_url_small;
			cell.appendChild(img);
		}
   })
}