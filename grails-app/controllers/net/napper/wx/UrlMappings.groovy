package net.napper.wx

class UrlMappings {

    static mappings = {

        group "/api", {
            group "/v1", {
                group "/archive", {
                    "/$request?/$id?" namespace: "v1", controller: "archive", action: "index"
//                    "/last/$n?" namespace: "v1", controller: "archive", action: "last"
//                    "/$archiveID" namespace: "v1", controller: "archive", action: "byID"
                }

                group "/sync", {
                    "/last?" namespace: 'v1', controller: "data", action: "currentData"
                    "/update" (namespace: 'v1', controller: "data") {
                            action = [POST: "updateData"]
                    }
                }
            }
        }
//        "/v1" {
//            "/archive"(controller: "archive", namespace: 'v1') {
//                "/last/$n?"(action: "last")
//            }
//        }

//        delete "/$controller/$id(.$format)?"(action:"delete")
//        get "/$controller(.$format)?"(action:"index")
//        get "/$controller/$id(.$format)?"(action:"show")
//        post "/$controller(.$format)?"(action:"save")
//        put "/$controller/$id(.$format)?"(action:"update")
//        patch "/$controller/$id(.$format)?"(action:"patch")

        //"/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
