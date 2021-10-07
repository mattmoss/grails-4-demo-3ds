package com.example

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import org.grails.datastore.mapping.engine.event.PreInsertEvent
import spock.lang.Specification

class EventListenerSpec extends Specification
        implements ServiceUnitTest<GameListenerService>, DataTest {

    void setupSpec() {
        mockDomain Game
    }

    def 'test that listener sets serial number on insert'() {
        given:
        Game game = new Game(
                name: 'Catan',
                genre: 'bar',
                minPlayers: 1,
                maxPlayers: 4,
                serialNumber: '-fake-',
        )

        when:
        service.onPreInsert(new PreInsertEvent(datastore, game))

        then:
        game.serialNumber == 'NATAC-042'
    }

}
