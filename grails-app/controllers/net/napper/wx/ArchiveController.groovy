package net.napper.wx


import grails.rest.*
import grails.converters.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ArchiveController {

    private static final Logger logger = LoggerFactory.getLogger(ArchiveController.class)
	static responseFormats = ['json', 'xml']

    static namespace = "v1"

    def ArchiveService

    def index() {
        def request = params?.request
        def idOrN = params?.int('id')
        def archive = null

        switch(request){
            case 'last':
                if (!idOrN) {
                    idOrN = 10
                }
                archive = archiveService.mostRecent(idOrN)
                break
            case 'since':
                archive = archiveService.sinceID(idOrN, 2000)
                break
            default:
                if (idOrN) {
                    archive = Archive.read(idOrN)

                    if (!idOrN) {
                        response.status = 404
                        return
                    }
                }
                else {
                    archive = archiveService.mostRecent(1)
                }
        }
        render archive as JSON
    }

    def updateData(){

        def data = request.JSON



    }
}
