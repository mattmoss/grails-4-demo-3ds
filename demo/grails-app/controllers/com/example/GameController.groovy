package com.example

import grails.rest.RestfulController

class GameController extends RestfulController<Game> {

    static responseFormats = ['json', 'xml']

    GameController() {
        super(Game)
    }

    def index(Integer max) {
        if (max < 0) { max = null }
        params.max = Math.min(max ?: 10, 100)
        respond listAllResources(params), model: [("${resourceName}Count".toString()): countResources()]
    }

}
