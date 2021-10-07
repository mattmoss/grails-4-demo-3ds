package com.example

// Note: UniversalId not quite right, temporarily disabled.
class Game implements /*UniversalId<Game>,*/ Expandable<Game> {

    String name
    String genre
    Integer minPlayers
    Integer maxPlayers

    String serialNumber     // populated by GameListenerService before insert

    static constraints = {
        // id bindable: true
        name blank: false, unique: true
        genre blank: false
        minPlayers min: 1
        maxPlayers min: 1
        serialNumber nullable: true
    }

}
