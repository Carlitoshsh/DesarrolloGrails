package desarrollograils

class Post{

    String topic
    Date dateCreated
    Date lastUpdate
    boolean isAllowed

    static constraints = {
        topic size: 3..50
       // dateCreated min: new Date()
        // lastUpdate min: dateCreated
    }

}
