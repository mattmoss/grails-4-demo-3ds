package com.example

class Game {
    String name
    String genre
    Integer minPlayers
    Integer maxPlayers

    static constraints = {
        name blank: false, unique: true
        genre blank: false
        minPlayers min: 1
        maxPlayers min: 1
    }
}
