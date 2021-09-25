package com.example

import groovy.transform.CompileStatic
import org.grails.datastore.gorm.GormEntity

@CompileStatic
trait UniversalId<D> extends GormEntity<D> {

    UUID id = UUID.randomUUID()

    int hashCode() {
        id.hashCode()
    }

    boolean equals(Object other) {
        if (other == null) {
            return false
        }

        if (this.is(other)) {
            return true
        }

        if (other instanceof UniversalId<D>) {
            return id == other.id
        }

        false
    }
}
