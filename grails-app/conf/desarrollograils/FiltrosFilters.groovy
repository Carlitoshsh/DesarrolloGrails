package desarrollograils

class PostFilters {

    def filters = {
        all(controller:'*', action:"index",invert:true) {
            before = {
                authStatus = session.user
                if(!authStatus != 'logged') {
                    redirect(controller: 'Post' ,action:'index')
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
