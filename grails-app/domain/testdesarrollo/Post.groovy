package testdesarrollo

class Post{

    String topic
    Date dateCreated
    Date lastUpdate
    boolean isAllowed

    def comment(){

    }

    def rate(){

    }

    def share(){

    }


    static constraints = {
        topic size: 3..50
       // dateCreated min: new Date()
        // lastUpdate min: dateCreated
    }

}
