package com.example

import groovy.transform.CompileStatic
import org.grails.datastore.gorm.GormEntity

@CompileStatic
trait Expandable<D> extends GormEntity<D> {

    // This map can be accessed via the getter. No need for a setter, and the lack of a setter
    // makes this read-only property transient automatically. Note: map is still read/write.
    private final Map customExpandProperties = new HashMap()

    Map getCustomExpandProperties() {
        customExpandProperties
    }

}
