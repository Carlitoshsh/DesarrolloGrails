package testdesarrollo

class Admin extends User{

    int level
    double rating
    //static hasMany = [forums: Forum]

    static constraints = {
        level   range: 1..5
        rating  range: 0..100
    }

}