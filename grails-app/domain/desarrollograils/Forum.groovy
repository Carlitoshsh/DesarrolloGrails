package desarrollograils

class Forum{

    String name
    Date dateCreated
    String category

    static constraints = {
        name unique: true, size: 3..20
        dateCreated min: new Date() // Debe ser futura
        category size: 3..15
    }

}