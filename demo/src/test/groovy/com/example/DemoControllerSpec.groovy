package com.example

import com.example.DemoController
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class DemoControllerSpec extends Specification implements ControllerUnitTest<DemoController> {

    void 'test expected response'() {
        when:
        controller.index()

        then:
        response.contentAsString == 'The magic number is 42.'
    }
}
