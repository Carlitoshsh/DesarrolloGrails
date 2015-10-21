package desarrollograils

class User {

    String name
    String lastname
    int age
    String username
    String password

    static constraints = {
        name blank: false, minSize: 3, maxSize:50
        lastname blank: false, size: 3..50
        age nullable: false, min: 13
        username blank: false, unique: true
        password blank: false, matches: "((?=.*[0-9])(?=.*[a-zA-Z]).{8,})", minSize: 8
    }
}
