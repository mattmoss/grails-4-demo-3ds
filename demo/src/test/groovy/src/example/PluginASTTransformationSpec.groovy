package src.example

import com.example.MagicNumber
import spock.lang.Specification

class PluginASTTransformationSpec extends Specification {

    void 'test that AST transformation provided by plugin is working'() {
        expect:
        new SomeClass().magicNumber == 42
    }
}

@MagicNumber
class SomeClass { }
