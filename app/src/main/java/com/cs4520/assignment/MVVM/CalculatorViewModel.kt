package com.cs4520.assignment.MVVM

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    val liveData = MutableLiveData<String>()
    private var model: CalcModel = CalcModel()

    private fun operations(num1: Double?, num2: Double?, operation: (Double, Double) -> Double) {
        if (num1 == null || num2 == null) {
            liveData.value = "Cannot have Null inputs"
        } else {
          liveData.value = operation(num1, num2).toString()

        }
    }

    fun add(num1: Double?, num2: Double?) {
        operations(num1, num2, model::add)
    }
    fun subtract(num1: Double?, num2: Double?) {
        operations(num1, num2, model::subtract)

    }

    fun multiply(num1: Double?, num2: Double?) {
        operations(num1, num2, model::multiply)
    }

    fun divide(num1: Double?, num2: Double?) {
        if (num2 == 0.0) {
            liveData.value = "Cannot divide by 0"
        } else{
            operations(num1,num2, model::divide)
        }
    }

}