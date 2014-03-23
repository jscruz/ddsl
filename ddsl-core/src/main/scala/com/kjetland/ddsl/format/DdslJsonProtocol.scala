package com.kjetland.ddsl.format

import spray.json.DefaultJsonProtocol
import spray.json.JsObject
import spray.json.RootJsonFormat
import spray.json.JsValue
import spray.json.DeserializationException
import spray.json.JsNumber
import spray.json.JsString
import com.kjetland.ddsl.model.ServiceRequest
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.TimeZone
import com.kjetland.ddsl.model.ServiceId

object DdslJsonProtocol extends DefaultJsonProtocol {
  implicit object ServiceRequestJsonFormat extends RootJsonFormat[ServiceRequest] {
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"))
    def write(serviceRequest: ServiceRequest) = JsObject(
      "service" -> JsObject(
          "environment" -> JsString(serviceRequest.sid.environment),
          "name" -> JsString(serviceRequest.sid.name),
          "type" -> JsString(serviceRequest.sid.serviceType),
          "version" -> JsString(serviceRequest.sid.version)
       ),
      "client"  -> JsObject(
          "environment" -> JsString(serviceRequest.cid.environment),
          "name" -> JsString(serviceRequest.cid.name),
          "version" -> JsString(serviceRequest.cid.version),
          "ip" -> JsString(serviceRequest.cid.ip)
       ),
      "timestamp" -> JsString(dateFormat.format(Calendar.getInstance().getTime()))
    )
    def read(value: JsValue) = {
        throw new NotImplementedError("Json to ServiceRequest not implemented")
    }
  }
}