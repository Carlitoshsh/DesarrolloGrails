package testdesarrollo

class Regular extends User{

    int postViews
    int strikesNumber
    int starsNumber

    static constraints = {
        postViews min: 0
        strikesNumber range: 0..3
        starsNumber range: 0..5
    }

}