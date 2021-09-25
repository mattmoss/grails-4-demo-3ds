package com.example

import grails.testing.gorm.DataTest
import spock.lang.Specification

class UniversalIdSpec extends Specification implements DataTest {

    @Override
    Class<?>[] getDomainClassesToMock() {
        [Game]
    }

    def 'test that Game id has a value'() {
        when:
        Game game = new Game()

        then:
        game.id != null
    }

    def 'test that Game initialized with an id keeps that value'() {
        given:
        UUID myId = UUID.fromString("f8fa39d0-6e97-4775-8f13-44e5f1611e64")

        // By default, Grails does not make id bindable. That can either be added to the domain
        // class (e.g. `id bindable: true` constraint) or just set manually. Here, Game has the
        // bindable constraint.
        when:
        Game game = new Game(id: myId)

        then:
        game.id == myId
    }

    def 'test that two Games are equals even if data differs' () {
        given:
        Game a = new Game(name: 'Something')
        Game b = new Game(name: 'Different')
        a.id = b.id

        expect:
        a == b
    }

    def 'test that two Games are not equal if data is same but id differ'() {
        given:
        Game a = new Game(name: 'equal')
        Game b = new Game(name: 'equal')

        expect:
        a.id != b.id
        a != b
    }
}
