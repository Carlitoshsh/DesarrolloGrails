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
        strikesNumber range: 0..3
        starsNumber range: 0..5
    }

}