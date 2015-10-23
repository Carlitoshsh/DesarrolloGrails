package testdesarrollo

import grails.test.mixin.TestFor
import spock.lang.Specification


@TestFor(Admin)
class AdminSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test level"() {
        when:
        def adm = new Admin(rating: 6.8,age: 20, name: "x"*10, username: "kokoriko", password: "as31234ww", lastname:"perez")
        adm.level = level
        adm.validate()


        then:
        adm.hasErrors() == !valido


        where:
        level     | valido
          0      | false //Minimo 1
          6      | false // Maximo 5
          2      | true
          1      | true
          5      | true


    }
    def "test rating"() {
        when:
        def adm = new Admin(level: 4,age: 20, name: "x"*10, username: "kokoriko", password: "as31234ww", lastname:"perez")
        adm.rating = rating
        adm.validate()


        then:
        adm.hasErrors() == !valido


        where:
        rating     | valido
         -1.0      | false // Minimo 0
         101       | false // Maximo 100
         0.0       | true
         99.0      | true


    }

}