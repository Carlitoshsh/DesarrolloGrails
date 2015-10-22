package testdesarrollo

class Regular extends User{

    int postViews = 0
    int strikesNumber
    int starsNumber

    static constraints = {
        postViews min: 0, nullable: false
        strikesNumber range: 0..3, nullable: false
        starsNumber range: 0..5, nullable: false
    }

}