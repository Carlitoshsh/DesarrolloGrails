package desarrollograils

class FiltrosFilters {

    def filters = {
        all(controller:'*', action:"index",invert:true) {
            before = {
       //         if(!session.user != "logged"){
       //             redirect(action:'index')
       //             return false;
   //             }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
