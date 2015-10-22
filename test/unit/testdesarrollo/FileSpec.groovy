package testdesarrollo

import grails.test.mixin.TestFor
import spock.lang.Specification

import java.util.regex.Pattern
import java.util.regex.Matcher



@TestFor(File)
class FileSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test fileType"() {
        Pattern pattern= Pattern.compile(".+[/].+")

        when:
        String s=new String()
        s="sdkjskdjs"
        def file = new File(size: 1024.3, content:s.getBytes())
        file.fileType = fileType
        boolean rta = rta1

        then:
        Matcher matcher= pattern.matcher(fileType)
        matcher.matches()== rta1


        where:
        fileType   | rta1
        "/no"      | false
        "si/"      | false
        "si/si"    | true
        "s/s"      | true
        " "        | false
    }

    def "test size"() {
        when:
        String s=new String()
        s="sdkjskdjs"
        def file = new File(fileType: "si/si",content:s.getBytes())
        file.size = size
        boolean rta = rta1

        then:
        (size<=10240)== rta1


        where:
        size     | rta1
        0      | true //Minimo 1
        1.0    | true
        10240  |true
        10241  |false

    }

    def "test content"() {
        when:
        def file = new File(fileType: "si/si",size: 4.5)
        file.content = content
        boolean rta = rta1

        then:
        (content !=null)== rta1


        where:
        content     | rta1
        35      | true //Minimo 1
        null |false
    }
}