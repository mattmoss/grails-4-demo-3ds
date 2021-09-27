package com.example

import grails.testing.gorm.DataTest
import spock.lang.Specification

class ExpandableSpec extends Specification implements DataTest {

    final CUSTOM_EXPAND_PROPS = 'customExpandProperties'

    @Override
    Class<?>[] getDomainClassesToMock() {
        [Game]
    }

    def 'test that Game has custom expand properties map'() {
        when:
        Game game = new Game()

        then:
        game.hasProperty CUSTOM_EXPAND_PROPS
    }

    def 'test that a new Game has no extra props'() {
        when:
        Game game = new Game()

        then:
        game.customExpandProperties.isEmpty()
    }

    def 'test that Game custom props map is not persisted'() {
        when:
        def props = Game.gormPersistentEntity.persistentProperties

        then:
        !props*.name.contains(CUSTOM_EXPAND_PROPS)
    }

    def 'test that custom properties map itself cannot be set'() {
        when:
        Game game = new Game()
        game.customExpandProperties = null

        then:
        thrown(ReadOnlyPropertyException)
    }

    def 'test that custom properties can be set'() {
        when:
        Game game = new Game()
        game.customExpandProperties['extra'] = 'something something'

        then:
        noExceptionThrown()
        game.customExpandProperties.keySet().contains 'extra'
    }

    def 'test that custom properties can be read'() {
        when:
        Game game = new Game()
        game.customExpandProperties['extra'] = 'something something'

        then:
        game.customExpandProperties.extra == 'something something'
    }

}
