package com.cs4520.assignment3.MVP

class CalculatorModelImpl : CalculatorModel {
    override fun add(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    override fun subtract(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    override fun multiply(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    override fun divide(num1: Double, num2: Double): Double {
        return num1/num2
    }
}