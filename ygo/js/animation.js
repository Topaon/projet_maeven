function addCardAnimation(idElt){
    console.log(idElt)
    bodyElt = document.getElementById(idElt);
    bodyElt.style.animation = "add_to_deck 0.1s";
    setTimeout(function(){bodyElt.style.animation = null}, 100);
}