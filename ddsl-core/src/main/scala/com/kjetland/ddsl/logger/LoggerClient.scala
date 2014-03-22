package com.kjetland.ddsl.logger

import com.kjetland.ddsl.model.ServiceRequest

trait LoggerClient {
	def send(data: ServiceRequest)
}