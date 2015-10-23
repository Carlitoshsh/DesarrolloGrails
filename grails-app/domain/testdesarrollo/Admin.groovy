package testdesarrollo

class Admin extends User{

    int level
    double rating
    //static hasMany = [forums: Forum]

    static constraints = {
        level   blank:false, nullable: false, range: 1..5
        rating  blank:false, nullable: false, range: 0..100
    }

}