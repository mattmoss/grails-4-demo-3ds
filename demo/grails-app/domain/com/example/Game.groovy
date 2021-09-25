package com.example

class Game implements UniversalId<Game> {

    String name
    String genre
    Integer minPlayers
    Integer maxPlayers

    static constraints = {
        id bindable: true
        name blank: false, unique: true
        genre blank: false
        minPlayers min: 1
        maxPlayers min: 1
    }

}
