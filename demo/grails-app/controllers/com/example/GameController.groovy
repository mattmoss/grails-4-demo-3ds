package com.example

import grails.rest.RestfulController

class GameController extends RestfulController<Game> {

    static responseFormats = ['json', 'xml']

    GameController() {
        super(Game)
    }

}
