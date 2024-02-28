package com.cs4520.assignment.MVVM

class CalcModel {
     fun add(num1: Double, num2: Double): Double {
        return num1 + num2
    }

     fun subtract(num1: Double, num2: Double): Double {
        return num1 - num2
    }

     fun multiply(num1: Double, num2: Double): Double {
        return num1 * num2
    }

     fun divide(num1: Double, num2: Double): Double {
        if (num2 == 0.0) throw ArithmeticException("Divide by 0 is not allowed")
        return num1/num2
    }
}