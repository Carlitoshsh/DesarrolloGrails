package testdesarrollo

class Forum{

    String name
    Date dateCreated
    String category

    static constraints = {
        name nullable: false, unique: true, size: 3..20
        dateCreated nullable: false, min: new Date().next() // Debe ser futura
        category nullable: false, size: 3..15
    }

}