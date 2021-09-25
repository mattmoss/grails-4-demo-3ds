package com.example


import spock.lang.Specification

class PluginASTTransformationSpec extends Specification {

    void 'test that AST transformation provided by plugin is working'() {
        expect:
        new SomeClass().magicNumber == 42
    }
}

@MagicNumber
class SomeClass { }
