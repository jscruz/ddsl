package com.kjetland.ddsl.format

import org.scalatest.FlatSpec
import com.kjetland.ddsl.format.DdslJsonProtocol._
import com.kjetland.ddsl.model._
import spray.json._
import spray.json.DefaultJsonProtocol._
import scala.util.matching.Regex

class ServiceRequestTransformerTest extends FlatSpec {
	"A DdslJsonProtocol" should "transform a ServiceRequest to a JSON" in {
	  var serviceId = ServiceId("a","b","c","d")
	  var serviceRequest = ServiceRequest(ServiceId("a","b","c","d"),ClientId("e","f","g","h"))
	  val json : String = serviceRequest.toJson.compactPrint
	  assert(json.contains("{\"service\":{\"environment\":\"a\",\"name\":\"c\",\"type\":\"b\",\"version\":\"d\"},\"client\":{\"environment\":\"e\",\"name\":\"f\",\"version\":\"g\",\"ip\":\"h\"},\"timestamp\":"))
	  val matches = new Regex("[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}") findAllIn json
	  assert( matches.size === 1)
	}
	
	it should "transform from a valid JSON a ServiceRequestObject"
}