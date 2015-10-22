package testdesarrollo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test name"(){
        when:
        def usr = new User()
        usr.name = name
        usr.validate()

        then:
        usr.hasErrors() == !valido

        where:
        name  | valido
        " " | false // Minimo son tres caracteres not blank
        "A"*2 | false // Minimo son tres caracteres
        "A"*51 | false // Minimo son tres caracteres
    }

    def "test lastName"(){
        when:
        def usr = new User(age: 20, name: "x"*10, username: "kokoriko", password: "as31234ww")
        usr.lastname = last
        usr.validate()

        then:
        usr.hasErrors() == !valido

        where:
        last | valido
        "" | false // Minimo son tres caracteres
        "A"*41 | true //maximo 50

    }


    def "test AGE"(){
        when:
        def usr = new User( name: "x"*10, lastname: "123456", username: "kokoriko", password: "as31234ww")
        usr.age = last
        usr.validate()

        then:
        usr.hasErrors() == !valido

        where:
        last | valido
        10| false // min 13
        50 | true //maximo 50

    }

    def "test username"(){
        when:
        def usr = new User(age: 20, name: "x"*10, lastname: "ws"*10,  password: "as31234ww")
        usr.username = username1
        def usr2 = new User(age: 20, name: "x"*10, lastname: "ws"*10,  password: "as31234ww")
        usr2.username = username2
        boolean rta=  rta1

        then:
        (username1 != username2) == rta1

        where:
        username1 | username2 | rta1
        "uno" | "uno" | false // not unique
        "A"*4 | "C"*3 | true //diferentes

    }

    def "test password"(){
        when:
        def usr = new User(age: 20, name: "x"*10, username: "kokoriko", lastname: "as31234ww")
        usr.password = pass
        usr.validate()

        then:
        usr.hasErrors() == !valido

        where:
        pass | valido
        "" | false
        "1234SsSs" | true //longitud 8

    }

}
