package testdesarrollo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Post)
class PostSpec extends Specification{

    def "Prueba de topic"(){
        when:
        def tema = new Post(dateCreated: new Date(2015,10,22), lastUpdate: new Date(2015,10,22), isAllowed: true)
        tema.topic = topic
        boolean rta = valid

        then:
        ( topic.size() > 2 && topic.size() < 51 ) == valid

        where:
        topic | valid
        "x"*51 | false
        "x"*50 | true
        "x"*25 | true
        "x"*3 | true
        "x"*2 | false
    }

    def "Prueba fecha creacion del post"(){
        when:
        def tema = new Post(topic: "x"*25, lastUpdate: new Date(2015,10,22), isAllowed: true)
        tema.dateCreated = creado
        boolean rta = valid

        then:
        (new Date()).compareTo(creado) > 0

        where:
        creado | valid
        new Date() | false
        new Date().next() | true
        new Date(2010,2,3) | false
    }

    def "Prueba fecha actualizacion del post"(){
        when:
        def tema = new Post(topic: "x"*25, dateCreated: new Date(2015,10,22), isAllowed: true)
        tema.lastUpdate = update
        boolean rta = valid

        then:
        (new Date()).compareTo(update) > 0

        where:
        update | valid
        new Date() | false
        new Date().next() | true
        new Date(2015,12,13) | true
    }

}