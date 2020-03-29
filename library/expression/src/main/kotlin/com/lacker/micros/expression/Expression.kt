package com.lacker.micros.expression

interface Expression {

    val type: Type

    fun eval(variables: Map<String, Any>): Any

    fun toSql(): String
}