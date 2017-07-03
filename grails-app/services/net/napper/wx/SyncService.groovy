package net.napper.wx

import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional
class SyncService {

    def redisService
    def redisServiceCache

    def updateCache(data){

        redisService.live = data

        return
    }

    def currentData() {
        def liveData = redisService?.live

        if (!liveData) return null

        Map data = new JsonSlurper().parse(liveData.bytes) as Map

        return data
    }
}
