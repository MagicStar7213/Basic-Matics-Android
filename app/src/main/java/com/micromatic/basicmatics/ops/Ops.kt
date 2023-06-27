package com.micromatic.basicmatics.ops

import kotlin.math.floor

fun divide(num1: Double, num2: Double): String {
    return when {
        floor(num1 / num2) == (num1 / num2) -> (num1 / num2).toInt().toString()
        else -> (num1 / num2).toString()
    }
}

fun remainder(num1: Double, num2: Double): String {
    return when {
        floor(num1 % num2) == (num1 % num2) -> (num1 % num2).toInt().toString()
        else -> (num1 % num2).toString()
    }
}

fun multiply(num1: Double, num2: Double): String {
    return when {
        floor(num1 * num2) == (num1 * num2) -> (num1 * num2).toInt().toString()
        else -> (num1 * num2).toString()
    }
}

fun add(num1: Double, num2: Double): String {
    return when {
        floor(num1 + num2) == (num1 + num2) -> (num1 + num2).toInt().toString()
        else -> (num1 + num2).toString()
    }
}

fun subtract(num1: Double, num2: Double): String {
    return when {
        floor(num1 - num2) == (num1 - num2) -> (num1 - num2).toInt().toString()
        else -> (num1 - num2).toString()
    }
}