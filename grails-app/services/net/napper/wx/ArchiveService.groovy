package net.napper.wx

import grails.transaction.Transactional
import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Transactional
class ArchiveService {

    private static final Logger logger = LoggerFactory.getLogger(ArchiveService.class)

    def dataSource

    def mostRecent(Integer n) {

        def q = new Sql(dataSource)
        if (!n) n = 15

        List all = q.rows "SELECT * FROM vw_Archive a ORDER BY a.id DESC LIMIT :n", [n: n]
        return all
    }

    def sinceID(Long id, Integer maxRecords){

        def q = new Sql(dataSource)

        List all = q.rows "SELECT * FROM vw_Archive a WHERE a.id > :id ORDER BY a.id DESC LIMIT :max", [id: id, max: maxRecords]
        return all
    }
}
