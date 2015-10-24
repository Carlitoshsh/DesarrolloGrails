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
    static belongsTo = [regular:Regular, forum:Forum]
    static hasMany = [files:File]
    static mapping = {
        files fetch: "join"
        dateCreated defaultValue: new Date()
        lastUpdate defaultValue: new Date()
        regular joinTable: [key:'owner_id']
        forum joinTable: [key: 'fatherForum_id']
    }


    static constraints = {
        topic nullable: false, size: 3..50
        dateCreated nullable: false, min: new Date().next()
        lastUpdate nullable: false, min: new Date().next()
        isAllowed nullable: false

    }

}
