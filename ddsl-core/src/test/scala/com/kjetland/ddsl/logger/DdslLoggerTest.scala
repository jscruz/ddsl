package com.kjetland.ddsl.logger

import org.scalatest._
import org.junit.Test
import org.junit.Assert._
import org.joda.time.DateTime

class DdslLoggerTest extends FlatSpec {
	class LoggerStub extends LoggerClient {
		var data = ""
				var sent = false
				override def send (dataToSend: String){
			data = dataToSend
					sent = true
		}
	}
	

  "A DdslLogger" should "use the logger client to send the data" in {
    val loggerClient = new LoggerStub
    val logger = new DdslLogger(loggerClient)
    val myData = "This is my data"
    logger.log(myData)
    
    assert(loggerClient.sent == true)
    assert(loggerClient.data == myData)
  }
}