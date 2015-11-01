package testdesarrollo

class Post{

    String topic
    Date dateCreated
    Date lastUpdate
    boolean isAllowed
    ArrayList<String> comments = new ArrayList<String>()
    int rate

    static belongsTo = [regular:Regular, forum:Forum]
    static hasMany = [files:File]

    static mapping = {
        regular key:'owner_id'
        forum key: 'fatherForum_id'
    }

    def beforeInsert(){
        this.dateCreated = new Date().next()
    }

    def beforeUpdate(){
        this.lastUpdate = new Date().next()
    }


    static constraints = {
        topic nullable: false, size: 3..50
        dateCreated nullable: false, min: new Date().next()
        lastUpdate nullable: false, min: new Date().next()
        isAllowed nullable: false
        rate nullable: false, min: 0
    }

}
