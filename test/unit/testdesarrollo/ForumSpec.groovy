package testdesarrollo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Forum)
class ForumSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test name"(){
        when:
        def foro = new Forum()
        foro.name = name
        boolean rta = rta1

        then:
        ( name.size() > 2 && name.size() < 51 ) == rta1

        where:
        name  | rta1
        " " | false // Minimo son tres caracteres not blank
        "a"*2 | false // Minimo son tres caracteres
        "a"*51 | false // Minimo son tres caracteres
        "a"*50 | true // Minimo son tres caracteres
    }

    def "test category"(){
        when:
        def foro = new Forum()
        foro.category = category
        boolean rta = rta1

        then:
        ( category.size() > 2 && category.size() < 16 ) == rta1

        where:
        category  | rta1
        " " | false // Minimo son tres caracteres not blank
        "a"*2 | false // Minimo son tres caracteres
        "a"*51 | false // Minimo son tres caracteres
        "a"*15 | true // Minimo son tres caracteres
    }

    def "test dateCreate"(){
        when:
        def foro = new Forum()
        foro.dateCreated = dc
        boolean rta = rta1

        then:
        (new Date()).before(dc) == rta1

        where:
        dc | rta1
        new Date() | false
        (new Date())+1 | true
    }


}
