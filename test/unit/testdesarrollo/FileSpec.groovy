package testdesarrollo

import grails.test.mixin.TestFor
import spock.lang.Specification


@TestFor(File)
class FileSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test fileType"() {

        when:
        def file = new File(size: 1024.3, content:"contenido".getBytes())
        file.fileType = fileType
        file.validate()

        then:
        file.hasErrors() == !valido

        where:
        fileType   | valido
        "/no"      | false
        "si/"      | false
        "si/si"    | true
        "s/s"      | true
        " "        | false
    }

    def "test size"() {

        when:
        def file = new File(fileType: "si/si",content:"contenidos".getBytes())
        file.size = size
        file.validate()

        then:
        file.hasErrors()==!valido

        where:
        size   | valido
        0      | true //Minimo 1
        1.0    | true
        10240  |true
        10241  |false

    }

    def "test content"() {
        when:
        def file = new File(fileType: "si/si",size: 4.5)
        file.content = content
        file.validate()

        then:
        file.hasErrors()==!valido

        where:
        content   | valido
        "prueba".getBytes() | true //Minimo 1
         null      |false
    }
}