package testdesarrollo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Regular)
class RegularSpec extends Specification {
    def setup() {
    }

    def cleanup() {
    }

    def "test postView"(){
        when:
        def regular = new Regular(strikesNumber: 1, starsNumber: 1)
        regular.postViews = post
        boolean rta = rta1

        then:
        ( post >= 0 ) == rta1

        where:
        post  | rta1
        -1 | false
        0 | true
        100 | true
    }

    def "test strikes"(){
        when:
        def regular = new Regular(postViews: 1, starsNumber: 1)
        regular.strikesNumber = strike
        boolean rta = rta1

        then:
        (strike >= 0 && strike <= 3) == rta1

        where:
        strike | rta1
        -1 | false
        4 | false
        0 | true
        3 | true
    }

    def "test stars"(){
        when:
        def regular = new Regular(postViews: 1, strikesNumber: 1)
        regular.starsNumber = star
        boolean rta = valido

        then:
        (star >= 0 && star <= 5) == valido

        where:
        star | valido
        -1| false
        6 | false
        0 | true
        5 | true
    }
}
