window.onload=function(){
	getImages();
}

function getImages(){
	fetch("https://db.ygoprodeck.com/api/v7/cardinfo.php?archetype=Salamangreat", {
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
			var img = document.createElement('img');
			img.src = data[x].card_images[0].image_url_small;
			if(img.width==168 && img.height==246){
				img.className = "img_slot";
				bodyElt.appendChild(img);
//				console.log(data[x]);
			}
		}
   })
}