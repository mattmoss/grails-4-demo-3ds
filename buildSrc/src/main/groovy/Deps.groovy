import groovy.transform.CompileStatic

@CompileStatic
class Deps {
        final static springBoot = [
                logging : 'org.springframework.boot:spring-boot-starter-logging',
                autoconfigure : 'org.springframework.boot:spring-boot-autoconfigure',
        ]
        final static grails = [
                core : 'org.grails:grails-core'
        ]
}
