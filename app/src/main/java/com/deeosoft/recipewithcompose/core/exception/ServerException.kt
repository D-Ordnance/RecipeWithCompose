package com.deeosoft.recipewithcompose.core.exception

import java.lang.Exception

class ServerException(override var message: String): Exception(message)