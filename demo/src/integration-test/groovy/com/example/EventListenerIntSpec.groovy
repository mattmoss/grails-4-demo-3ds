package com.example

import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
class EventListenerIntSpec extends Specification {

    GameDataService gameDataService

    def 'saving a game generates a serial number'() {
        when:
        Game game = gameDataService.save('Catan', 'strategy', 3, 4)

        then:
        game.serialNumber == 'NATAC-042'
    }
}

