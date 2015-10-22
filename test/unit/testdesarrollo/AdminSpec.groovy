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
        def adm = new Admin(rating: 6.8)
        adm.level = level
        boolean rta = rta1

        then:
        (level>=1 && level<=5)== rta1


        where:
        level     | rta1
          0      | false //Minimo 1
          6      | false // Maximo 5
          2      | true
          1      | true
          5      | true

    }
    def "test rating"() {
        when:
        def adm = new Admin(level: 4)
        adm.rating = rating
        boolean rta = rta1

        then:
        (rating>=0.0 && rating<=100.0)== rta1

        where:
        rating     | rta1
        -1.0      | false // Minimo 0
        100.1     | false // Maximo 100
        0.0       | true
        99.0      | true


    }

}