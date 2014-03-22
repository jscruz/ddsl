package com.kjetland.ddsl.logger

import org.scalatest._
import org.junit.Test
import org.junit.Assert._
import org.joda.time.DateTime
import com.kjetland.ddsl.model._

class DdslLoggerTest extends FlatSpec {
	class LoggerStub extends LoggerClient {
			var sent = false
			var data : ServiceRequest = _
			override def send (dataToSend: ServiceRequest){
					data = dataToSend
					sent = true
		}
	}
	

  "A DdslLogger" should "use the logger client to send the data" in {
    val loggerClient = new LoggerStub
    val logger = new DdslLogger(loggerClient)
    val myData = "This is my data"
    val serviceRequest = ServiceRequest(ServiceId("test", "http", "myTestService", "1.0"), ClientId("test", "client", "1.0","127.0.0.1"));
    logger.log(serviceRequest)
    
    assert(loggerClient.sent == true)
    assert(loggerClient.data.cid == serviceRequest.cid)
    assert(loggerClient.data.sid == serviceRequest.sid)
  }
}