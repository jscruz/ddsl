package com.kjetland.ddsl.logger

trait LoggerClient {
	def send(data: String)
}