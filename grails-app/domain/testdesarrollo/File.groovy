package testdesarrollo

class File{

    String fileType
    Byte[] content
    double size

    def download(){

    }

    def share(){

    }

    static constraints = { fileType nullable: false, matches: "([.+[\\\\/].+]+)"
       size max: (double)10240
        
    }

}
