package testdesarrollo

class File{

    String fileType
    Byte[] content
    double size

    def download(){

    }

    def share(){

    }

    static mapping = { firstName column: 'post_belongs_id' }

    static belongsTo = [post:Post]
    static constraints = {
        fileType blank: false,  nullable: false, matches: "(.+[/].+)"
        size nullable: false, max: (double)10240
        content nullable: false
        
    }

}
