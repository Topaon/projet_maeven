var list = ["un", "deux", "trois", "quatre", "cinq"]

var filtre = "cinq"

function filter1(word){
    if(word.length > 4){
        return true
    } else {
        return false
    }
}

console.log(list.filter((word) => filter1(word)))