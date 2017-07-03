package net.napper.wx

import grails.rest.*

@Resource(readOnly = true, formats = ['json'])
class Archive {

    Long id
    Date dateTime
    Integer interval
    Double barometer
    Double inTemp
    Double outTemp
    Double inHumidity
    Double outHumidity
    Double windSpeed
    Double windDir
    Double windGust
    Double windGustDir
    Double rainRate
    Double rain
    Double dewpoint
    Double windchill
    Double heatindex
    Double ET
    Double radiation
    Double UV
    Double rxCheckPercent
    Double txBatteryStatus

    static mapping = {
        table schema: 'weewx',name: 'vw_Archive'
        cache usage: 'read-only'
        sort id: "desc"
        id column: 'dateTime', sqlType: 'int(11)' , insertable: false, updateable: false
        dateTime column: 'dateTime', sqlType: 'datetime', insertable: false, updateable: false
        interval column: 'interval'
        barometer column: 'barometer'
        inTemp column: 'inTemp'
        outTemp column: 'outTemp'
        inHumidity column: 'inHumidity'
        outHumidity column: 'outHumidity'
        windSpeed column: 'windSpeed'
        windDir column: 'windDir'
        windGust column: 'windGust'
        windGustDir column: 'windGustDir'
        rainRate column: 'rainRate'
        rain column: 'rain'
        dewpoint column: 'dewpoint'
        windchill column: 'windchill'
        heatindex column: 'heatindex'
        radiation column: 'radiation'
        rxCheckPercent column: 'rxCheckPercent'
        txBatteryStatus column: 'txBatteryStatus'
        version false
        autoTimestamp false
    }

    static constraints = {
    }
}
