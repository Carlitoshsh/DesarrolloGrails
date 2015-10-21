package desarrollograils

class Admin extends User{

    int level
    double rating
    //static hasMany = [forums: Forum]

    static constraints = {
        level size: 1..5
        ranking size: 0..100
    }

}