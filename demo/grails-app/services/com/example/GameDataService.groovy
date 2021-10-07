package com.example

import grails.gorm.services.Service
import groovy.transform.CompileStatic

@CompileStatic
@Service(Game)
interface GameDataService {
    Game save(String name, String genre, Integer minPlayers, Integer maxPlayers)

    List<Game> findAll()
}
