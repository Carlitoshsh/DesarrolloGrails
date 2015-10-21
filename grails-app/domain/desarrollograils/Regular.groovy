package desarrollograils

class Regular extends User{

    int postViews
    int strikesNumber
    int starsNumber

    def comment(){

    }

    def rate(){

    }

    def share(){

    }

    static constraints = {
        postViews min: 0
        strikesNumber size: 0..3
        starsNumber size: 0..5
    }

}