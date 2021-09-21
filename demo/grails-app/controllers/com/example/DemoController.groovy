package com.example

class DemoController {

    def index() {
        def helper = new ClassWithMagicNumber()

        def message = "The magic number is ${helper.magicNumber}."

        render message
    }

}

