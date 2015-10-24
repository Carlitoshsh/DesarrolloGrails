package testdesarrollo

class Admin extends User{

    int level
    double rating
    static hasMany = [forums: Forum]
    static mapping = {
        forums fetch: "join"
    }

    def c = Admin.createCriteria()
    def results = c { order("level", "desc")}

    static constraints = {
        level   blank:false, nullable: false, range: 1..5
        rating  blank:false, nullable: false, range: 0..100
    }

}