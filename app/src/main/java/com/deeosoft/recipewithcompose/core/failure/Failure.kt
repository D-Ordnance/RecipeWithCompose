package com.deeosoft.recipewithcompose.core.failure

abstract class Failure(var message: String){
    abstract fun getFormattedMessage(): String
}