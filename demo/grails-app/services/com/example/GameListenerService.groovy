package com.example

import grails.events.annotation.gorm.Listener
import groovy.transform.CompileStatic
import org.grails.datastore.mapping.engine.event.PreInsertEvent

@CompileStatic
class GameListenerService {

    @Listener(Game)
    void onPreInsert(PreInsertEvent event) {
        String name = event.entityAccess.getProperty('name')
        String serial = generateSerial(name)
        event.entityAccess.setProperty('serialNumber', serial)
    }

    static String generateSerial(String name) {
        name.reverse().toUpperCase() + "-042"
    }

}
