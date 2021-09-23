package com.example

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        addSampleData()
    }

    def destroy = {
    }

    @Transactional
    def addSampleData() {
        [
                [name: 'Settlers of Catan', genre: 'strategy', minPlayers: 3, maxPlayers: 4],
                [name: 'Poker', genre: 'gambling', minPlayers: 2, maxPlayers: 10],
                [name: 'Patchwork', genre: 'abstract', minPlayers: 2, maxPlayers: 2],
        ].each {
            new Game(it).save(flush: true)
        }
    }
}
