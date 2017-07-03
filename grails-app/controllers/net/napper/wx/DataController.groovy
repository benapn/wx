package net.napper.wx


import grails.rest.*
import grails.converters.*
import groovy.json.JsonSlurper
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class DataController {

    private static final Logger logger = LoggerFactory.getLogger(DataController.class)
	static responseFormats = ['json', 'xml']

    static namespace = "v1"

    def SyncService


    def currentData() {
        def current = syncService.currentData() ?: [:]
        render current as JSON

    }

    def updateData() {
        def data = JSON.parse(request.parameterMap.data[0].toString())
        syncService.updateCache(data)
        response.status = 200

    }
}