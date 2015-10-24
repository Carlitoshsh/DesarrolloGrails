package testdesarrollo

class Forum{

    String name
    Date dateCreated
    String category

    static belongsTo = [admin:Admin]
    static hasMany = [posts:Post] //revisar este no se si esta bien //Si esta bien
    static mapping = {
        posts fetch: "join"
        dateCreated defaultValue: new Date()
    }

    static constraints = {
        name nullable: false, unique: true, size: 3..20
        dateCreated nullable: false, min: new Date().next() // Debe ser futura
        category nullable: false, size: 3..15
    }

}