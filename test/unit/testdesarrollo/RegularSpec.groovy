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
        def regular = new Regular(strikesNumber: 1, starsNumber: 1,age: 20, name: "x"*10, username: "kokoriko", password: "as31234ww", lastname:"perez")
        regular.postViews = post
        regular.validate()

        then:
        regular.hasErrors()==!rta1

        where:
        post  | rta1
        -1 | false
        0 | true
        100 | true
    }

  def "test strikes"(){
        when:
        def regular = new Regular(postViews: 1, starsNumber: 1, age: 20, name: "x"*10, username: "kokoriko", password: "as31234ww", lastname:"perez")
        regular.strikesNumber = strike
        regular.validate()
        boolean rta = rta1

        then:
        regular.hasErrors()==!rta1
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
        def regular = new Regular(postViews: 1, strikesNumber: 1, age: 20, name: "x"*10, username: "kokoriko", password: "as31234ww", lastname:"perez")
        regular.starsNumber = star
        regular.validate()

        then:
        regular.hasErrors()==!valido

        where:
        star | valido
        -1| false
        6 | false
        0 | true
        5 | true
    }
}
