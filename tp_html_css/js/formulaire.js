function clickFormulaire(){
    let inpuNom = document.querySelector("input[name='nom']");
    let valeurSaisieNom = inpuNom.value;

    let inpuPrenom = document.querySelector("input[name='prenom']");
    let valeurSaisiePrenom = inpuPrenom.value;

    let bodyElt = document.getElementById("message");
    bodyElt.innerHTML = valeurSaisieNom + valeurSaisiePrenom;
}