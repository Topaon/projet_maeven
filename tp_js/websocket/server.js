var app = require('express')()
var http = require('http').Server(app)
var io = require('socket.io')(http)

app.get("/", function(req, res){
    res.sendFile(__dirname + '/index.html')
})

// Création d'un évenement 'connection d'un client au serveur'
io.on('connection', function(socket){
    console.log("Connection d'un client")
    // event : envoie d'un message par un client
    socket.on('chat message', function(msg){
        console.log("message reçu : " + msg)
        io.emit('chat message', msg)
    })
})

// Démarrage du serveur
http.listen(3000, function(){
    console.log("Server running on port 3000")
})