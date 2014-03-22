package com.kjetland.ddsl.logger

import com.kjetland.ddsl.model.ServiceRequest

class DdslLogger (var loggerClient : LoggerClient) {
  
	def log (data: ServiceRequest) {
	  loggerClient.send(data)
	} 
}