package com.kjetland.ddsl.logger

class DdslLogger (var loggerClient : LoggerClient) {
	def log (data: String) {
	  loggerClient.send(data)
	} 
}